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

}
