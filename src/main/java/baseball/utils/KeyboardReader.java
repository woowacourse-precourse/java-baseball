package baseball.utils;

import baseball.utils.resources.InputKey;
import camp.nextstep.edu.missionutils.Console;

public class KeyboardReader {
    private static final String REGEX_INTEGER = "-?\\d+";

    private KeyboardReader() { }

    public static boolean readLineAsBooleanKey(InputKey trueKey, InputKey falseKey) {
        String inputLine = readLineForAll();
        if (inputLine.equals(trueKey.text())) {
            return true;
        }
        if (inputLine.equals(falseKey.text())) {
            return false;
        }
        throw new IllegalArgumentException("[오류] 잘못된 키워드를 입력하였습니다.");
    }

    public static String readLineOnlyInteger() {
        String inputLine = readLineForAll();
        if (!inputLine.matches(REGEX_INTEGER)) {
            throw new IllegalArgumentException("[오류] 입력값은 정수만 허용됩니다.");
        }
        return inputLine;
    }

    private static String readLineForAll() {
        return Console.readLine();
    }
}