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
}
