package baseball.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class CounterpartModel {
    private final int score;

    CounterpartModel(int score) {
        this.score = pickNumberInRange(1, 9);
    }

    public int getScore() {
        return score;
    }
}
