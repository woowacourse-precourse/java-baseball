package baseball;

public class ComparedNumberResult {

    private int ballCount;
    private int strikeCount;

    public ComparedNumberResult() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void plusStrikeCount() {
        strikeCount++;
    }

    public void plusBallCount() {
        ballCount++;
    }

    @Override
    public String toString() {

        if (ballCount + strikeCount == 0) {
            return Message.getNothingMessage();
        }

        StringBuilder message = new StringBuilder();

        if (ballCount > 0) {
            message.append(ballCount + Message.getBallMessage());
        }

        if (ballCount > 0 && strikeCount > 0) {
            message.append(" ");
        }

        if (strikeCount > 0) {
            message.append(strikeCount + Message.getStrikeMessage());
        }

        return message.toString();


    }
}
