package baseball.domain.number;


import java.util.Objects;

public class BaseballNumber {
    public static final String ERROR_NUMBER_SIZE = "[ERROR] 숫자는 1과9사이의 숫자로 이루어져야 합니다.";
    public static final String ERROR_INPUT_IS_NUMBER = "[ERROR] 입력은 오직 숫자만 가능합니다.";

    private static final Integer MAX_NUMBER = 9;
    private static final Integer MIN_NUMBER = 1;

    private final Integer number;

    /**
     * 정수를 입력하는 경우
     *
     * @param input
     */
    public BaseballNumber(final Integer input) {
        validateNumberIsLessThanMinNumber(input);
        validateNumberIsMoreThanMaxNumber(input);
        this.number = input;
    }

    public BaseballNumber(final String input) {
        validateInputIsNumber(input);

        Integer number = Integer.parseInt(input);
        
        validateNumberIsLessThanMinNumber(number);
        validateNumberIsMoreThanMaxNumber(number);
        this.number = number;
    }

    private void validateInputIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_INPUT_IS_NUMBER);
        }

    }

    private void validateNumberIsMoreThanMaxNumber(Integer input) {
        if (input > MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_NUMBER_SIZE + String.format(" [number:%d]", input));
        }
    }

    private void validateNumberIsLessThanMinNumber(Integer input) {
        if (input < MIN_NUMBER) {
            throw new IllegalArgumentException(ERROR_NUMBER_SIZE + String.format(" [number:%d]", input));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseballNumber that = (BaseballNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }

    public Integer number() {
        return number;
    }
}