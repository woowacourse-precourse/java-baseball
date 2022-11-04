package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;

import static java.lang.System.exit;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ArrayList<Integer> computerNumbers = getRandomNumbers();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            try {
                checkInput(input);
            } catch (IllegalArgumentException e) {
                exit(0);
            }

        }
    }

    private static void checkInput(String input) {
        int num = Integer.parseInt(input);
        HashSet<Character> eachNums = new HashSet<>();
        // 각 자리 수에 중복이 있는지 확인.
        for (int i = 0; i < 3; i++) {
            eachNums.add(input.charAt(i));
        }
        if (eachNums.size() != 3) throw new IllegalArgumentException();
        if (num < 0 || num > 999) throw new IllegalArgumentException();
    }

    public static ArrayList<Integer> getRandomNumbers() {
        ArrayList<Integer> threeRandomNumbers = new ArrayList<>(3);
        while (threeRandomNumbers.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            insertNumber(threeRandomNumbers, num);
        }
        return threeRandomNumbers;
    }

    private static void insertNumber(ArrayList<Integer> threeRandomNumbers, int num) {
        if (!threeRandomNumbers.contains(num))
            threeRandomNumbers.add(num);
    }
}
