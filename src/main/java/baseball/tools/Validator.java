package baseball.tools;

public class Validator {
    private final String baseballNumber;

    public Validator(String baseballNumber) {
        this.baseballNumber = baseballNumber;
    }

    public boolean checkBaseballNumber() {
        // 3자리인지
        if (!checkBaseballNumberLength()) {
            return false;
        }
        // 1~9 사이의 숫자를 입력했는지
        if (!checkBaseballNumberRange()) {
            return false;
        }
        return true;
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

}
