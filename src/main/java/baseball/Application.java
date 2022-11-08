package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {

    }

    // 2. Print the game start message
    public static String printTheGameStartMessage() {
        return "숫자 야구 게임을 시작합니다.";
    }

    /*
     3. Get random number
     - get random number after making sure all digits are different
     */
    public static String getRandomNumber() {
        List<String> numberList = new ArrayList<>();

        while (numberList.size() < 3) {
            String digit = String.valueOf(Randoms.pickNumberInRange(1, 9));

            numberList = updateNumberList(digit, numberList);
        }

        return String.join("", numberList);
    }

    private static List<String> updateNumberList(String digit, List<String> numberList) {
        if (!numberList.contains(digit)) {
            numberList.add(digit);
        }
        return numberList;
    }

}
