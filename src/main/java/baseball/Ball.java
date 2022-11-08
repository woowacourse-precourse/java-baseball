package baseball;

public class Ball {

    private final Integer number;

    public Ball(int number) {

        validateRange(number);
        this.number = number;

    }

    public Ball(char ch) {
        this(Integer.parseInt(String.valueOf(ch)));
    }

    private void validateRange(int number) {
        if (number < 1 || 9 < number) {
            throw new IllegalArgumentException("공의 숫자는 1~9의 자연수만 가능합니다.");
        }
    }



}
