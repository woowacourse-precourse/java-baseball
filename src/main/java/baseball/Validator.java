package baseball;

public class Validator {
    public static final String LENGTH_EXCEPTION = "3자리 숫자만 입력할 수 있습니다.";
    public static final String HAVING_ANOTHER_CHARACTER_EXCEPTION = "숫자만 포함될 수 있습니다.";
    public static final String HAVING_ZERO_EXCEPTION = "0은 포함될 수 없습니다.";
    public static final String HAVING_SAME_NUMBER_EXCEPTION = "서로 다른 숫자만 입력할 수 있습니다";
    public static final String RESTART_RESPONSE_EXCEPTION = "1, 2 이외의 문자가 입력되었습니다.";

    public static void validateLength(String numberStringUserInput) {
        if (numberStringUserInput.length() != Game.NUMBER_LENGTH) {
            throw new IllegalArgumentException(LENGTH_EXCEPTION);
        }
    }

    //TODO 숫자만 포함 

    //TODO 0 포함 X

    //TODO 서로 다른 숫자만 입력

    //TODO 재식작 응답 검증 시 1,2 이외의 문자 X


}
