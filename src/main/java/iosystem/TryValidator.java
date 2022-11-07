package iosystem;

public class TryValidator {

    private TryValidator(){

    }
    private static final int MAX_NUMBER_LENGTH = 3;
    private static final String NUMBER_REGEXP = "^[1-9]+$";

    public static void validate(String userInput) {
        isNumberBetweenOneToNine(userInput);
        validateNumberLength(userInput);
    }

    public static void isNumberBetweenOneToNine(String input) {
        if (!input.matches(NUMBER_REGEXP)) {
            throw new IllegalArgumentException("1~9사이의 숫자로만 이루어진 수를 입력할 수 있습니다.");
        }
    }

    public static void validateNumberLength(String input) {
        if (input.length() != MAX_NUMBER_LENGTH) {
            throw new IllegalArgumentException("3자리 수만 입력할 수 있습니다.");
        }
    }

}
