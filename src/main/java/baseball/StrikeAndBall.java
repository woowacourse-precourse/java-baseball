package baseball;

import java.util.List;

public class StrikeAndBall {
    int strike, ball;

    StrikeAndBall() {
        strike = 0;
        ball = 0;
    }

    private void addStrike() {
        this.strike++;
    }

    private void addBall() {
        this.ball++;
    }

    public GameMassage getResult() {
        return GameMassage.findStrikeAndBallMessage(this);
    }

    private void isStrike(int computerDigit, int userDigit) {
        if (computerDigit == userDigit) {
            addStrike();
        }
    }

    private void isBall(int computerDigit, int userDigit, List<Integer> computer) {
        if ((computerDigit != userDigit) && (computer.contains(userDigit))) {
            addBall();
        }
    }

    public void isStrikeOrBall(List<Integer> computer, List<Integer> user) {
        for (int i = 0; i < user.size(); i++) {
            isStrike(computer.get(i), user.get(i));
            isBall(computer.get(i), user.get(i), computer);
        }
    }
}
