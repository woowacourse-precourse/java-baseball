package baseball;

public class UserNumberException {
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
        if (numbers.length() != SystemMessage.NUMBER_SIZE) {
            return true;
        }
        return false;
    }

    public boolean isNumber(String numbers) {
        for (int i = 0; i < SystemMessage.NUMBER_SIZE; i++) {
            if (!('1' <= numbers.charAt(i) && numbers.charAt(i) <= '9')) {
                return true;
            }
        }
        return false;
    }

    public boolean hasDuplicatedNumber(int number, String numbers) {
        for (int i = 1; i < SystemMessage.NUMBER_SIZE; i++) {
            if (number == numbers.charAt(i)) {
                return true;
            }
        }
        for (int i = 1; i < SystemMessage.NUMBER_SIZE-1; i++) {
            if (numbers.charAt(i) == numbers.charAt(i+1)) {
                return true;
            }
        }
        return false;
    }
}
