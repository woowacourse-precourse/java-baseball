package iosystem;

public class RetryValidator {

    private RetryValidator(){

    }
    private static final String NUMBER_REGEXP = "^[1-2]";

    public static void validate(String userInput) {
        isNumberBetweenOneToNine(userInput);
    }

    public static void isNumberBetweenOneToNine(String input) {
        if (!input.matches(NUMBER_REGEXP)) {
            throw new IllegalArgumentException("1~2사이의 1자리 수만 입력할 수 있습니다.");
        }
    }

}
