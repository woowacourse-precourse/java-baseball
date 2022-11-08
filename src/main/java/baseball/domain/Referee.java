package baseball.domain;

import java.util.List;

public class Referee {

    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";

    private List<Integer> opponentAnswer;
    private int strike;
    private int ball;
    private final int INITIAL_VALUE = 0;
    private final int MAX_VALUE = 3;

    public void saveOpponentAnswer(List<Integer> opponentAnswer) {
        this.opponentAnswer = opponentAnswer;
    }

    private boolean isStrike(List<Integer> quessNumber, int idx) {

        if (quessNumber.get(idx) == Opponent.getNumber(opponentAnswer, idx)) {
            return true;
        }
        return false;
    }

    private boolean isBall(List<Integer> quessNumber, int idx) {
        if (opponentAnswer.contains(quessNumber.get(idx))) {
            return true;
        }
        return false;
    }

    private boolean isNothing() {
        return strike + ball == INITIAL_VALUE;
    }

    public boolean isAllStrike() {
        return strike == MAX_VALUE;
    }

    private void initStrikeAndBall() {
        strike = INITIAL_VALUE;
        ball = INITIAL_VALUE;
    }

    public void CaculateResult(List<Integer> playerAnswer) {
        initStrikeAndBall();

        for (int idx = INITIAL_VALUE; idx < playerAnswer.size(); idx++) {
            if (isStrike(playerAnswer, idx)) {
                strike++;
                continue;
            }

            if (isBall(playerAnswer, idx)) {
                ball++;
            }
        }
    }

    public String getResult() {
        if (isNothing()) {
            return NOTHING;
        }
        return BallORStrike();
    }

    private String BallORStrike() {
        if (strike == INITIAL_VALUE) {
            return ball + BALL;
        }

        if (ball == INITIAL_VALUE) {
            return strike + STRIKE;
        }

        return ball + BALL + " " + strike + STRIKE;
    }
}
