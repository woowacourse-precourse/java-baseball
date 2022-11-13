package baseball.computer.generator;

public class GeneratorValidate {
    private static final String OVER_CASE_MESSAGE = "더 이상 숫자를 생성할 수 없습니다.";

    public static void validate(int numberCase) {
        if (numberCase > RandomNumberGenerator.MAX_NUMBER_OF_CASE) {
            throw new IllegalArgumentException(OVER_CASE_MESSAGE);
        }
    }

}
