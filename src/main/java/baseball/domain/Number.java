package baseball.domain;

public class Number {
    private int value;

    public Number(int value) {
        this.value = value;
    }

    public Number(char value) {
        this.value = toInt(value);
    }

    private int toInt(char value) {
        value -= 48;
        if (value == 0) {
            throw new IllegalArgumentException("범위(1~9)를 벗어나는 수가 포함되었습니다.");
        }
        if (value < 1 || value > 9) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되었습니다.");
        }
        return value;
    }
}
