package baseball;

public class UserNumberException {
    static final int INPUT_NUMBER_LENGTH = 3;
    public void checkException(String numbers) {
        validateNumberLength(numbers);
        isNumber(numbers);

        int number = numbers.charAt(0);
        hasDuplicatedNumber(number, numbers);
    }

    public void validateNumberLength(String numbers) {
        if (numbers.length() != INPUT_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void isNumber(String numbers) {
        for (int i = 0; i < INPUT_NUMBER_LENGTH; i++) {
            if (!('1' <= numbers.charAt(i) && numbers.charAt(i) <= '9')) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void hasDuplicatedNumber(int number, String numbers) {
        for (int i = 1; i < INPUT_NUMBER_LENGTH; i++) {
            if (number == numbers.charAt(i)) {
                throw new IllegalArgumentException();
            }
        }
        for (int i = 1; i < INPUT_NUMBER_LENGTH-1; i++) {
            if (numbers.charAt(i) == numbers.charAt(i+1)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
