package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String menu = "";
        String input = "";
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computer = makeRandomNumber();
        for (int i : computer) {
            System.out.print(i);
        }
        input = getNumber();
        List<Integer> answer = compareNumber(input, computer);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    public static List<Integer> makeRandomNumber() {
        List<Integer> number = new ArrayList<>();

        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
        return number;
    }

    public static String getNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }

        return input;
    }

    public static List<Integer> compareNumber(String input, List<Integer> computer) {
        int strikeCnt = 0;
        int ballCnt = 0;

        for (int i = 0; i < computer.size(); i++) {
            String str = Integer.toString(computer.get(i));

            if (input.contains(str) && input.indexOf(str) == i) {
                strikeCnt++;
            } else if (input.contains(str)) {
                ballCnt++;
            }
        }
        return List.of(strikeCnt, ballCnt);
    }
}
