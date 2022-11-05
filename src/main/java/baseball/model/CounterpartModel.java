package baseball.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class CounterpartModel {
    private final int score;

    public CounterpartModel() {
        this.score = pickNumberInRange(1, 9);
    }

    public int getScore() {
        return score;
    }
}
