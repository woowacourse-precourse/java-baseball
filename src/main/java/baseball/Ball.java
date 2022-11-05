package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import static baseball.Const.WRONG_INPUT;

public class Ball {
    private Integer number;

    public Ball() { // Default 생성자
    }

    public Ball(char number) {
        if (!validate(number)) {
            throw new IllegalArgumentException(WRONG_INPUT);
        }

        this.number = number - '0';
    }

    public boolean validate(char number) {
        int charToInt = number - '0';

        if (1 <= charToInt && charToInt <= 9) {
            return true;
        }

        return false;
    }

    public void generate() {
        this.number = Randoms.pickNumberInRange(1, 9);
    }

    public Integer getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object object) {
        Ball ball = (Ball) object;

        if (ball.getNumber() == this.number) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return this.number.hashCode();
    }
}
