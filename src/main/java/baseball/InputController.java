package baseball;

import static baseball.NumberController.isStringNumberInRange;

import java.util.ArrayList;
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

    public static void checkThreeNum(String input) {
        if (!isStringNumberInRange(input, 1, 9)
                || input.length() != 3
                || !isUniqueChars(input)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
}
