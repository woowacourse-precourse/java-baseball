package baseball.domain;

public class Validator {

    private static final String FORBIDDEN_FORMAT_MESSAGE = "세자리 숫자만 입력해주세요";
    private static final String CONTAIN_CHAR_REGEX = "^[a-zA-Z가-힣]*$";
    private static final String BLANK = " ";

    public static void validate(String input) {
        validateRandomNumberExceedLength(input);
        validateContainChar(input);
        validateContainBlank(input);
        validateContainZero(input);
    }

    public static void validateRandomNumberExceedLength(String input) {
        if(input.length() < 3){
            throw new IllegalArgumentException(FORBIDDEN_FORMAT_MESSAGE);
        }
    }

    public static void validateContainChar(String input) {
        if(input.matches(CONTAIN_CHAR_REGEX)){
            throw new IllegalArgumentException(FORBIDDEN_FORMAT_MESSAGE);
        }
    }

    public static void validateContainBlank(String input) {
        if(input.contains(BLANK)){
            throw new IllegalArgumentException(FORBIDDEN_FORMAT_MESSAGE);
        }
    }

    public static void validateContainZero(String input) {
        if(input.contains("0")){
            throw new IllegalArgumentException(FORBIDDEN_FORMAT_MESSAGE);
        }
    }
}
