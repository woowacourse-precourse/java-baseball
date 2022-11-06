package validator;

public class Validator {
    private static final String LENGTH_VALIDATION_FAILED = "입력한 숫자의 길이가 3이 아닙니다.";

    public static boolean validateLength(String input, int baseLength) {
        if(input.length() == baseLength)
            return true;
        throw new IllegalArgumentException(LENGTH_VALIDATION_FAILED);
    }
}
