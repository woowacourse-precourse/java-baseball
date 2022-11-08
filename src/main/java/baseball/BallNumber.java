package baseball;

public class BallNumber {
    private final int index;
    private final String number;

    public BallNumber(int index, int number) {
        this(index, String.valueOf(number));
    }

    public BallNumber(int index, String number) {
        isNotDigitExceptionCheck(number);
        outOfRangeNumberExceptionCheck(number);
        outOfRangeIndexExceptionCheck(index);
        this.index = index;
        this.number = number;
    }

    public int getIndex() {
        return index;
    }

    public String getNumber() {
        return number;
    }

    private void isNotDigitExceptionCheck(String number) {
        boolean isNotDigit = number.chars().anyMatch(c -> !Character.isDigit(c));
        if (isNotDigit) {
            throw new IllegalArgumentException("문자가 아닌 숫자를 넣어주세요.");
        }
    }

    private void outOfRangeNumberExceptionCheck(String number) {
        int num = Integer.parseInt(number);
        if (num < 1 || num > 9) {
            throw new IllegalArgumentException("숫자의 범위가 1~9를 초과하지 않도록 넣어주세요.");
        }
    }

    private void outOfRangeIndexExceptionCheck(int index) {
        if (index > 2 || index < 0) {
            throw new IllegalArgumentException("3자리의 숫자를 넣어주세요.");
        }
    }
}
