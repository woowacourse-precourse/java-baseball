package baseball;

public class InputNumber {
    String number;

    InputNumber(String number) {
        checkStringNumberLength(number);
        checkStringNumberIsNumber(number);
        this.number = number;
    }

    public void checkStringNumberLength(String number) {
        if ((number.length() < 1) || (number.length() > 3)) {
            throw new IllegalArgumentException();
        }
    }

    public void checkStringNumberIsNumber(String number) {
        boolean isCheckNumber = number.chars().allMatch(Character::isDigit);

        if (!isCheckNumber) {
            throw new IllegalArgumentException();
        }
    }
}
