package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Input {
    static List<Integer> computerRandomNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int random = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(random)) {
                computer.add(random);
            }
        }
        return computer;
    }
    static String userNumber() {
        System.out.print("숫자를 입력해 주세요 : ");
        return Console.readLine();
    }

    static boolean userNumberLengthCheck(String input) {
        if (input.length() != 3) {
            return false;
        }
        return true;
    }

    static boolean userNumberRepeatCheck(String input) {
        List<Integer> equal_number = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            if (equal_number.contains(input.charAt(i) - '0')) {
                return false;
            }
            equal_number.add(input.charAt(i) - '0');
        }
        return true;
    }

    static boolean userNumberRangeCheck(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i)-'0' <= 0) {
                return false;
            }
        }
        return true;
    }


}
