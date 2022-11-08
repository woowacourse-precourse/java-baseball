package domain;

public class Number {
    private int number;

    public Number(int number) {
        if (numberRangeValidationTest(number)) {
            this.number = number;
        }
    }

    public Number(String numberInput) {
        try {
            int convertedNumber = Integer.parseInt(numberInput);

            if (numberRangeValidationTest(convertedNumber)) {
                this.number = convertedNumber;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력하신 값이 숫자가 아닙니다.");
        }
    }

    private boolean numberRangeValidationTest(int checkNumber) {
        if (checkNumber < 1) {
            throw new IllegalArgumentException("숫자의 범위가 1 미만입니다.");
        }
        if (9 < checkNumber) {
            throw new IllegalArgumentException("숫자의 범위가 9를 초과합니다.");
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).number == this.number;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.number;
    }
}
