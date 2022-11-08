package baseball;

public class Result {
    private int ballCount;
    private int strikeCount;

    public void initialize() {
        ballCount = 0;
        strikeCount = 0;
    }

    public void increaseBallCount() {
        ballCount++;
    }

    public void increaseStrikeCount() {
        strikeCount++;
    }

    public String createResultMessage() {
        String resultMessage = "";

        if (ballCount == 0 && strikeCount == 0) {
            resultMessage = Settings.NOTHING;
        } else if (ballCount > 0 && strikeCount == 0) {
            resultMessage = ballCount + Settings.BALL;
        } else if (ballCount == 0 && strikeCount > 0) {
            resultMessage = strikeCount + Settings.STRIKE;
        } else if (ballCount > 0 && strikeCount > 0) {
            resultMessage = ballCount + Settings.BALL + " " + strikeCount + Settings.STRIKE;
        }

        return resultMessage;
    }

    public boolean isWrongAnswer() {
        return strikeCount < 3;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }
}
