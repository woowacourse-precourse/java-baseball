package baseball.tools;

public class Validator {
    private final String baseballNumber;

    public Validator(String baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public boolean checkBaseballNumber() {
        return checkBaseballNumberLength() &&
            checkBaseballNumberIsNumber() &&
            checkBaseballNumberRange();
    }

    private boolean checkBaseballNumberLength() {
        return baseballNumber.length() == 3;
    }

    private boolean checkBaseballNumberRange() {
        for (int i = 0; i < 3; i++) {
            int number = Integer.parseInt(String.valueOf(baseballNumber.charAt(i)));
            if (number == 0)
                return false;
        }
        return true;
    }

    private boolean checkBaseballNumberIsNumber() {
        for (int i = 0; i < 3; i++)
            if (!Character.isDigit(baseballNumber.charAt(i)))
                return false;
        return true;
    }

}
