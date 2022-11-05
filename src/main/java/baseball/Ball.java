package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import static baseball.Const.WRONG_INPUT;

public class Ball {
    private Integer number;
    private List<Integer> randomNumberList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

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
        this.number = Randoms.pickNumberInList(randomNumberList);
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

    @Override
    public String toString() {
        return "number : " + number;
    }
}
