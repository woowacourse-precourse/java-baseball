package baseball.uitls;

import java.util.List;

public class Hints {

    private List<Integer> hints;

    public Hints(List<Integer> hints) {
        this.hints = hints;
    }

    public int getBall() {
        return this.hints.get(0);
    }

    public int getStrike() {
        return this.hints.get(1);
    }

    public boolean hasBallStrike() {
        if (getBall() != 0 && getStrike() != 0) {
            return true;
        }
        return false;
    }

    public boolean hasOnlyBall() {
        if (getBall() != 0) {
            return true;
        }
        return false;
    }

    public boolean hasOnlyStrike() {
        if (getStrike() != 0) {
            return true;
        }
        return false;
    }

    public boolean isStrikeOut() {
        if (getStrike() == 3) {
            return true;
        }
        return false;
    }
}
