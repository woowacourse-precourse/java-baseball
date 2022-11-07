package baseball.user;

import static baseball.RuleConst.NUMBER_LENGTH;

public class InputValidator {

    public InputValidator() {
    }

    private boolean isZeroAtFirst(String number) {
        return number.charAt(0) == '0';
    }

    private boolean checkLength(String number) {
        return number.length() == NUMBER_LENGTH;
    }

    private long countNumber(String number, char target) {
        return number.chars().filter(ch -> ch == target).count();
    }

    private boolean anyDuplicated(String number) {
        for (int i = 1; i < 10; i++) {
            char characterized = (char) (i + 48);
            if (countNumber(number, characterized) > 1) {
                return true;
            }
        }
        return false;
    }

    public void validate(String number) {
        if (number.isBlank() || isZeroAtFirst(number) || !checkLength(number) || anyDuplicated(number)) {
            throw new IllegalArgumentException();
        }

        try {
            Integer.valueOf(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
