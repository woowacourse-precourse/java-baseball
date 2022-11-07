package baseball;

import java.util.List;

class Baseball {
    private static final String SCORE_NOTHING = "낫싱";
    private static final String SCORE_BALL = "볼";
    private static final String SCORE_STRIKE = "스트라이크";
    private static final int NUMBER_SIZE = 3;
    private static final int ZERO = 0;

    int strike = ZERO;
    int ball = ZERO;

    private void checkStrike(int computer, int user) {
        if (computer == user) {
            this.strike++;
        }
    }

    private void checkBall(int user, List<Integer> computers) {
        if (computers.contains(user)) {
            this.ball++;
        }
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball - this.strike;
    }

    private String getScore() {
        if (getBall() == ZERO && getStrike() == ZERO) {
            return SCORE_NOTHING;
        }
        if (getBall() == ZERO) {
            return getStrike() + SCORE_STRIKE;
        }
        if (getStrike() == ZERO) {
            return getBall() + SCORE_BALL;
        }
        return getBall() + SCORE_BALL + " " + getStrike() + SCORE_STRIKE;
    }
}
