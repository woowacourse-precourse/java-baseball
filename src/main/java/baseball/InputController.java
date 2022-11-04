package baseball;

import static baseball.NumberController.isStringNumberInRange;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InputController {
    private InputController() {
    }

    private static boolean isUniqueChars(String str) {
        List<Character> strings = new ArrayList<>();
        for (char c : str.toCharArray()) {
            if (strings.contains(c)) {
                return false;
            }
            strings.add(c);
        }
        return true;
    }

    public static void validateThreeNum(String input) {
        if (!isStringNumberInRange(input, 1, 9)
                || input.length() != 3
                || !isUniqueChars(input)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public static void validateFlagNum(String input) {
        if (!isStringNumberInRange(input, 1, 2)
                || !(Integer.parseInt(input) == 1 || Integer.parseInt(input) == 2)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public static List<Integer> getUniqueThreeNum() {
        String input = Console.readLine();
        InputController.validateThreeNum(input);
        return NumberController.convertStringToNumbers(input);
    }

    public static int getExitFlag() {
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

}
