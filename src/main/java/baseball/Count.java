package baseball;

import java.util.List;
import java.util.Objects;

public class Count {
    private int strike;
    private int ball;

    public Count() {
        this.strike = 0;
        this.ball = 0;
    }

    public void ballCount(List<Integer> ComputerNumList, List<Integer> playerNumList) {
        for (int i = 0; i< ComputerNumList.size(); i++) {
            if (Objects.equals(ComputerNumList.get(i), playerNumList.get(i))) {
                countStrike();
            }
            else if (ComputerNumList.contains(playerNumList.get(i))) {
                countBall();
            }
        }
    }

    public int getStrike() {
        return this.strike;
    }

    public void countStrike() {
        this.strike += 1;
    }

    public int getBall() {
        return this.ball;
    }

    public void countBall() {
        this.ball += 1;
    }
}
