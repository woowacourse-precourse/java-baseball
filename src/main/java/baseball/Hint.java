package baseball;

import java.util.ArrayList;
import java.util.List;

public class Hint {
    private int strike;
    private int ball;

    Hint(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    @Override
    public String toString() {
        List<String> hintList = new ArrayList<>();
        if (this.ball > 0) {
            hintList.add(this.ball + "볼");
        }
        if (this.strike > 0) {
            hintList.add(this.strike + "스트라이크");
        }

        if (hintList.size() == 0)
            return "낫싱";

        return String.join(" ", hintList);
    }
}
