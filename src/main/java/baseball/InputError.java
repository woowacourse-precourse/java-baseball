package baseball;

/**
 * 사용자 입력
 * 서로 다른 3자리 수
 * 게임이 끝난 경우 재시작 => 1, 종료 => 2
 * 잘못된 입력일 경우 IllegalArgumentException을 발생시킨 후 종료
 */
public class InputError {

    public static final String ERROR_MESSAGE = "잘못된 입력값입니다. 게임을 종료하겠습니다.";

    public static String replayOrStopExceptionCheck(String answer) {
        // 1, 2가 아닌 다른 값인지 검사

        if (answer.equals("1"))
            return answer;
        if (answer.equals("2"))
            return answer;
        throw new IllegalArgumentException(ERROR_MESSAGE);
    }

    public static String userNumberInputExceptionCheck(String answer) {
        /**
         * 서로 다른 3자리
         * 길이가 3이 아닌 경우 예외 발생
         * 중복된 수가 들어 있을 때 예외 발생
         * 각 자리가 숫자가 아닌경우 예외발생
         */

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

        return answer;
    }
}
