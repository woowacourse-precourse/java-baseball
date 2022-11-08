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

    Baseball(List<Integer> computers, List<Integer> userNumbers) {
        startGame(userNumbers, computers);
    }

    private void startGame(List<Integer> userNumbers, List<Integer> computers) {
        for (int position = 0; position < NUMBER_SIZE; position++) {
            int computerValue = computers.get(position);
            int userValue = userNumbers.get(position);

            checkStrike(computerValue, userValue);
            checkBall(userValue, computers);
        }
    }

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

    public String getScore() {
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
