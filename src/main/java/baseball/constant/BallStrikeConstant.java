package baseball.constant;

public enum BallStrikeConstant {
    NOTHING("낫싱", false),
    ONE_STRIKE("1스트라이크", false),
    TWO_STRIKE("2스트라이크", false),
    THREE_STRIKE("3스트라이크", true),
    ONE_BALL("1볼", false),
    ONE_BALL_ONE_STRIKE("1볼 1스트라이크", false),
    ONE_BALL_TWO_STRIKE("1볼 2스트라이크", false),
    TWO_BALL("2볼", false),
    TWO_BALL_ONE_STRIKE("2볼 1스트라이크", false),
    THREE_BALL("3볼", false);

    private String ballStrikeMessage;
    private boolean isFinish;

    BallStrikeConstant(String ballStrikeMessage, boolean isFinish) {
        this.ballStrikeMessage = ballStrikeMessage;
        this.isFinish = isFinish;
    }

    public String getBallStrikeMessage() {
        return ballStrikeMessage;
    }
    public boolean getIsFinish() { return isFinish; }

    public static BallStrikeConstant getResult(int ball, int strike) {
        BallStrikeConstant ballStrikeConstant = null;
        if (ball == 0) {
            if (strike == 0) {
                ballStrikeConstant = NOTHING;
            } else if (strike == 1) {
                ballStrikeConstant = ONE_STRIKE;
            } else if (strike == 2) {
                ballStrikeConstant = TWO_STRIKE;
            } else if (strike == 3) {
                ballStrikeConstant = THREE_STRIKE;
            }

        } else if (ball == 1) {
            if (strike == 0) {
                ballStrikeConstant = ONE_BALL;
            } else if (strike == 1) {
                ballStrikeConstant = ONE_BALL_ONE_STRIKE;
            } else if (strike == 2) {
                ballStrikeConstant = ONE_BALL_TWO_STRIKE;
            }

        } else if (ball == 2) {
            if (strike == 0) {
                ballStrikeConstant = TWO_BALL;
            } else if (strike == 1) {
                ballStrikeConstant = TWO_BALL_ONE_STRIKE;
            }
        } else if (ball == 3) {
            ballStrikeConstant = THREE_BALL;
        }
        return ballStrikeConstant;
    }
}
