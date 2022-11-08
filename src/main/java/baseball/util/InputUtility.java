package baseball.util;

import java.util.Arrays;
import java.util.List;

public class InputUtility {

    private static void isValidProcess(String input) {
        List<String> validProcess = Arrays.asList("1", "2");
        if (!validProcess.contains(input)) {
            throw new IllegalArgumentException("유효하지 않은 문자입니다.");
        }
    }

}
