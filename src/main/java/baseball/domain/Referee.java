package baseball.domain;

public class Referee {

    private Computer computer;
    private final Hint hint;

    public Referee(Computer computer) {
        this.computer = computer;
        this.hint = new Hint();
    }

    public Hint getHint(Balls userBalls) {
        hint.init();
        for (int i = 0; i < userBalls.getSize(); i++) {
            getStrike(userBalls, i);
            getBall(userBalls, i);
        }
        return this.hint;
    }

    private void getStrike(Balls userBalls, int index) {
        if (computer.getBallNumber(index).equals(userBalls.getBall(index))) {
            hint.increaseStrike();
        }
    }

    private void getBall(Balls userBalls, int index) {
        if (userBalls.isContain(computer.getBallNumber(index)) && !computer.getBallNumber(index)
                .equals(userBalls.getBall(index))) {
            hint.increaseBall();
        }
    }

    public boolean isEnd() {
        return hint.isOut();
    }
}
