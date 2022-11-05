package baseball;

public class UserNumberException {
    static final int INPUT_NUMBER_LENGTH = 3;
    public boolean checkException(String numbers) {
        if (validateNumberLength(numbers)) {
            return true;
        }
        if (isNumber(numbers)) {
            return true;
        }

        int number = numbers.charAt(0);
        if (hasDuplicatedNumber(number, numbers)) {
            return true;
        }
        return false;
    }

    public boolean validateNumberLength(String numbers) {
        if (numbers.length() != INPUT_NUMBER_LENGTH) {
            return true;
        }
        return false;
    }

    public boolean isNumber(String numbers) {
        for (int i = 0; i < INPUT_NUMBER_LENGTH; i++) {
            if (!('1' <= numbers.charAt(i) && numbers.charAt(i) <= '9')) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDuplicatedNumber(int number, String numbers) {
        for (int i = 1; i < INPUT_NUMBER_LENGTH; i++) {
            if (number == numbers.charAt(i)) {
                return true;
            }
        }
        for (int i = 1; i < INPUT_NUMBER_LENGTH-1; i++) {
            if (numbers.charAt(i) == numbers.charAt(i+1)) {
                return true;
            }
        }
        return false;
    }
}
