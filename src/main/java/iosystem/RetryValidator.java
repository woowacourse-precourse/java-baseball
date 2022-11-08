package iosystem;

import java.util.Objects;

public class RetryValidator {

    private RetryValidator(){

    }
    private static final String NUMBER_REGEXP = "^[1-2]";

    public static void validate(String input) {
        validateBlank(input);
        isNumberBetweenOneToNine(input);
    }

    public static void isNumberBetweenOneToNine(String input) {
        if (!input.matches(NUMBER_REGEXP)) {
            throw new IllegalArgumentException("1~2사이의 1자리 수만 입력할 수 있습니다.");
        }
    }

    private static void validateBlank(final String input){
        if (isBlank(input)){
            throw new IllegalArgumentException("null 이나 빈값이 들어올 수 없습니다.");
        }
    }

    private static boolean isBlank(String input) {
        return Objects.isNull(input) || input.isEmpty();
    }
}
