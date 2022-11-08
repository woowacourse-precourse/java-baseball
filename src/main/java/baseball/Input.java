package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private static final String ERROR_MESSAGE_BLANK = "공백은 입력할 수 없습니다.";

    public static String readString() {
        String inputString;
        inputString = Console.readLine();
        inputString = inputString.trim();
        validateBlank(inputString);
        return inputString.trim();
    }

    public static int readInt() {
        return Integer.parseInt(readString());
    }

    private static void validateBlank(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException(ERROR_MESSAGE_BLANK);
        }
    }

}
