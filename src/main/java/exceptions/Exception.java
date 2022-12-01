package exceptions;

public class Exception {
    protected static void validateCommonException(String value) {
        validateEmpty(value);
        validateZeroIncluded(value);
    }

    private static void validateEmpty(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateZeroIncluded(String value) {
        if (value.startsWith("0")) {
            throw new IllegalArgumentException();
        }
    }
}
