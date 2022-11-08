package baseball.core;

public class BallStrike {

    private static final String NOTHING = "낫싱";
    private static final String BALL = "%d볼";
    private static final String STRIKE = "%d스트라이크";

    private final int ballCount;
    private final int strikeCount;

    public BallStrike(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    @Override
    public String toString() {
        return makeHintMessage();
    }

    private String makeHintMessage() {
        String resultMessage;

        if (isNothing()) {
            resultMessage = makeNothingMessage();
        } else {
            resultMessage = makeBallStrikeResultString();
        }
        return resultMessage;
    }

    private boolean isNothing() {
        return ballCount == 0 && strikeCount == 0;
    }

    private String makeNothingMessage() {
        return NOTHING;
    }

    private String makeBallStrikeResultString() {
        StringBuilder sb = new StringBuilder();
        addBallString(sb);
        addStrikeString(sb);
        return sb.toString().trim();
    }

    private void addStrikeString(StringBuilder sb) {
        if (strikeCount != 0) {
            sb.append(String.format(STRIKE, strikeCount));
        }
    }

    private void addBallString(StringBuilder sb) {
        if (ballCount != 0) {
            sb.append(String.format(BALL, ballCount)).append(" ");
        }
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
