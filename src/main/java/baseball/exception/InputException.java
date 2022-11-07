package baseball.exception;

public class InputException {

    private static final String NOT_INTEGER_INPUT = "양의 정수를 입력해 주세요.";
    private static final String NOT_THREE_LENGTH_INTEGER_INPUT = "3자리의 수를 입력해 주세요.";
    private static final String INCLUDE_ZERO_INPUT = "0이 포함되지 않아야 합니다.";
    private static final String DUPLICATE_NUMBER_INPUT = "중복되지 않는 수를 입력해 주세요.";
    private static final String NOT_ONE_OR_TWO_INPUT = "1 또는 2를 입력해 주세요.";

    public static void throwNotIntegerInputError() {
        System.out.println(NOT_INTEGER_INPUT);
        throw new IllegalArgumentException();
    }

    public static void throwNotThreeLengthIntegerInputError() {
        System.out.println(NOT_THREE_LENGTH_INTEGER_INPUT);
        throw new IllegalArgumentException();
    }

    public static void throwIncludeZeroInputError() {
        System.out.println(INCLUDE_ZERO_INPUT);
        throw new IllegalArgumentException();
    }

    public static void throwDuplicateNumberInputError() {
        System.out.println(DUPLICATE_NUMBER_INPUT);
        throw new IllegalArgumentException();
    }

    public static void throwNotOneOrTwoInputError() {
        System.out.println(NOT_ONE_OR_TWO_INPUT);
        throw new IllegalArgumentException();
    }
}
