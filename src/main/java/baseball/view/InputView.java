package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final int END = 2;
    public static final String NOT_ONE_LENGTH = "입력된 길이가 1이 아닙니다";
    public static final String NOT_ONE_OR_TWO = "1 또는 2를 입력해야 합니다.";

    public static String userBaseballInput() {
        return Console.readLine();
    }

    public static int endOrRestartInput() {
        String input = Console.readLine();

        validateEndOrRestart(input);
        return Integer.parseInt(input);
    }

    private static void validateEndOrRestart(String input) {
        if (!isValidLength(input)) {
            throw new IllegalArgumentException(NOT_ONE_LENGTH);
        }
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException(NOT_ONE_OR_TWO);
        }
    }

    private static boolean isValidLength(String input) {
        return input.length() == 1;
    }
}
