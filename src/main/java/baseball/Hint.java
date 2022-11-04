package baseball;

import java.util.List;

public class Hint {

    private static final Integer BASEBALL_NUMBERS_LENGTH = 3;

    private Integer strike;

    private Integer ball;

    public Integer getStrike() {
        return strike;
    }

    public void resetHintCount() {
        this.strike = 0;
        this.ball = 0;
    }

    public void countBaseballResult(List<Integer> player, List<Integer> computer) {
        resetHintCount();
        for (int i = 0; i < BASEBALL_NUMBERS_LENGTH; i++) {
            if (player.get(i) == computer.get(i)) {
                this.strike += 1;
            } else if (computer.contains(player.get(i))) {
                this.ball += 1;
            }
        }
    }
}
