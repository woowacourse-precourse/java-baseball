package baseball.domain;

import java.util.List;

public class Player {
    private Balls guessBall;

    public void guessBall(List<Integer> guessNumber) {
        this.guessBall = Balls.convertNumberToBalls(guessNumber);
    }
}
