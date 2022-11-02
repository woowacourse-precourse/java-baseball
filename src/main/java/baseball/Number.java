package baseball;

public class Number {

    private final String ERROR_MESSAGE_SIZE = "숫자는 0~9 사이 값만 입력가능합니다.";

    private int number;

    public Number(int number) {
        validateSize(number);
        this.number = number;
    }

    private void validateSize(int number) {
        if ((number < 1) || (number > 9)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_SIZE);
        }
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object obj) {
        return this.number == ((Number)obj).getNumber();
    }

}
