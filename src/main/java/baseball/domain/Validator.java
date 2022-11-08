package baseball.domain;

public class Validator {

    private static final String FORBIDDEN_FORMAT_MESSAGE = "세자리 숫자만 입력해주세요";
    private static final String CONTAIN_CHAR_REGEX = "^[1-9]*$";
    private static final String BLANK = " ";
    private static final String FORBIDDEN_ZERO_MESSAGE = "0을 입력하지 마세요";

    public static void validate(String input) {
        if (input.isEmpty()) throw new IllegalArgumentException(FORBIDDEN_FORMAT_MESSAGE);
        validateRandomNumberExceedLength(input);
        validateContainChar(input);
        validateContainBlank(input);
        validateContainZero(input);
    }

    public static void validateRandomNumberExceedLength(String input) {
        if (input.length() > 3) {
            throw new IllegalArgumentException(FORBIDDEN_FORMAT_MESSAGE);
        }
    }

    public static void validateContainChar(String input) {
        if (!input.matches(CONTAIN_CHAR_REGEX)){
            throw new IllegalArgumentException(FORBIDDEN_FORMAT_MESSAGE);
        }
    }

    public static void validateContainBlank(String input) {
        if (input.contains(BLANK)){
            throw new IllegalArgumentException(FORBIDDEN_FORMAT_MESSAGE);
        }
    }

    public static void validateContainZero(String input) {
        if (input.contains("0")){
            throw new IllegalArgumentException(FORBIDDEN_ZERO_MESSAGE);
        }
    }
}
