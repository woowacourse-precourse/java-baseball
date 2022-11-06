package baseball;

public class Ball {
    private int number;

    public Ball(int number) {
        if (number<1 || 9<number) {
            throw new IllegalArgumentException("1~9 사이의 숫자만 입력해주세요.");
        } else {
            this.number = number;
        }
    }

    public int getBall() {
        return this.number;
    }


}
