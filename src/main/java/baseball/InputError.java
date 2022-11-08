package baseball;
public class InputError {

    public static final String ERROR_MESSAGE = "잘못된 입력값입니다. 게임을 종료하겠습니다.";

    public static void replayOrStopExceptionCheck(String answer) {
        if (!answer.equals("1") && !answer.equals("2"))
            throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    public static void userNumberInputExceptionCheck(String answer) {

        if (answer.length() != 3)
            throw new IllegalArgumentException(ERROR_MESSAGE);

        if (answer.charAt(0) == answer.charAt(1))
            throw new IllegalArgumentException(ERROR_MESSAGE);

        if (answer.charAt(0) == answer.charAt(2))
            throw new IllegalArgumentException(ERROR_MESSAGE);

        if (answer.charAt(1) == answer.charAt(2))
            throw new IllegalArgumentException(ERROR_MESSAGE);

        for (int i = 0; i < answer.length(); i++) {
            char n = answer.charAt(i);
            if (n < '1' || n > '9')
                throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }
}
