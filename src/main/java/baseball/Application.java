package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> gameNumberList = pickGameNumber();
        System.out.println(gameNumberList);
        List<Integer> userNumberList = inputGameNumber();
        List<Integer> strikeNumberList = new ArrayList<>();
        int strike = 0, ball = 0;
        for (int i = 0; i < 3 ; i++) {
            if (gameNumberList.get(i) == userNumberList.get(i)) {
                strike++;
                strikeNumberList.add(gameNumberList.get(i));
            }
        }
        System.out.println(strike + "스트라이크");
        System.out.println(userNumberList);
    }

    public static List<Integer> pickGameNumber() {
        List<Integer> gameNumberList = new ArrayList<>();
        while (gameNumberList.size() != 3) {
            checkNumber(gameNumberList);
        }
        return gameNumberList;
    }

    public static void checkNumber(List<Integer> numberList) {
        int num = Randoms.pickNumberInRange(1, 9);

        if (!numberList.contains(num)) {
            numberList.add(num);
        }
    }

    public static List<Integer> inputGameNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> userNumberList = new ArrayList<>();
        String inputNum = readLine();
        int i = 0;
        while (userNumberList.size() != 3) {
            userNumberList.add(Character.getNumericValue(inputNum.charAt(i)));
            i++;
        }
        return userNumberList;

    }
}
