package baseball.domain;

import java.util.List;

public class Referee {

    private Computer computer;
    private final Hint hint;

    public Referee(Computer computer) {
        this.computer = computer;
        this.hint = new Hint();
    }

    public Hint getHint(List<Integer> userBalls) {
        hint.init();
        for (int i = 0; i < userBalls.size(); i++) {
            getStrike(userBalls, i);
            getBall(userBalls, i);
        }
        return this.hint;
    }

    private void getStrike(List<Integer> userBalls, int index) {
        if (computer.getBallNumber(index) == userBalls.get(index)) {
            hint.increaseStrike();
        }
    }

    private void getBall(List<Integer> userBalls, int index) {
        if (userBalls.contains(computer.getBallNumber(index)) && computer.getBallNumber(index) != userBalls.get(index)) {
            hint.increaseBall();
        }
    }

    public boolean isEnd() {
        return hint.isOut();
    }
}
