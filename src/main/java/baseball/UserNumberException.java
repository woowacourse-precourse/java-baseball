package baseball;

public class UserNumberException {
    public void checkException(String numbers) {
        if (validateNumberLength(numbers)) {
            throw new IllegalArgumentException();
        }
        if (isNumber(numbers)) {
            throw new IllegalArgumentException();
        }

        int number = numbers.charAt(0);
        if (hasDuplicatedNumber(number, numbers)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean validateNumberLength(String numbers) {
        if (numbers.length() != SystemMessage.NUMBER_SIZE) {
            return true;
        }
        return false;
    }

    public boolean isNumber(String numbers) {
        for (int i = 0; i < SystemMessage.NUMBER_SIZE; i++) {
            if (!(ComputerNumber.MIN_NUMBER <= numbers.charAt(i) - '0' && numbers.charAt(i) - '0' <= ComputerNumber.MAX_NUMBER)) {
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
