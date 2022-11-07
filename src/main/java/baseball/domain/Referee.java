package baseball.domain;

public class Referee {
    public static final int INITIAL_VALUE = 0;
    public static final int ANSWER_COUNT = 3;
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";

    private BaseBallNumber computerNumber;
    private int strike;
    private int ball;

    public void saveComputerNumber( BaseBallNumber computerNumber ) {
        this.computerNumber = computerNumber;
    }

    public void judgeResult( BaseBallNumber playerNumber ) {
        initBallAndStrike();

        for ( int idx = 0; idx < playerNumber.size(); idx++ ) {
            if ( isStrike(playerNumber, idx) ) {
                strike++;
                continue;
            }

            if ( isBall(playerNumber, idx) ) {
                ball++;
            }
        }
    }

    private void initBallAndStrike() {
        strike = INITIAL_VALUE;
        ball = INITIAL_VALUE;
    }

    private boolean isStrike(BaseBallNumber playerNumber, int idx) {
        return computerNumber.hasNumber(playerNumber.getNthNumber(idx), idx);
    }

    private boolean isBall(BaseBallNumber playerNumber, int idx) {
        return computerNumber.containsNumber(playerNumber.getNthNumber(idx));
    }

    public String getResult() {
        if ( isNothing() ) {
            return NOTHING;
        }

        return ballAndStrike();
    }

    private boolean isNothing() {

        return strike + ball == INITIAL_VALUE;
    }

    private String ballAndStrike() {

        if ( isOnlyStrike() ) {
            return strike + STRIKE;
        }

        if ( isOnlyBall() ) {
            return ball + BALL;
        }

        return ball + BALL + " " + strike + STRIKE;
    }

    private boolean isOnlyBall() {
        return strike == INITIAL_VALUE;
    }

    private boolean isOnlyStrike() {
        return ball == INITIAL_VALUE;
    }

    public boolean isAnswer() {
        return strike == ANSWER_COUNT;
    }
}