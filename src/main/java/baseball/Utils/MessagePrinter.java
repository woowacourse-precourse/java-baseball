package baseball.Utils;

import baseball.Message.PlayMessage;

public class MessagePrinter {

    public void gameStart() {
        System.out.println(PlayMessage.GAME_START.toMessage());
    }

    public void inputNumbers() {
        System.out.print(PlayMessage.INPUT_NUMBERS.toMessage());
    }

    public void countBallAndStrike(int ballCount, int strikeCount) {
        String result;

        if (ballCount > 0 && strikeCount == 0) {
            result = ballToString(ballCount);
        } else if (strikeCount > 0 && ballCount == 0) {
            result = strikeToString(strikeCount);
        } else if (ballCount > 0 && strikeCount > 0) {
            result = ballToString(ballCount) + " " + strikeToString(strikeCount);
        } else {
            result = nothingToString();
        }

        System.out.println(result);
    }

    private String strikeToString(int count) {
        return String.valueOf(count) + PlayMessage.STRIKE.toMessage();
    }

    private String ballToString(int count) {
        return String.valueOf(count) + PlayMessage.BALL.toMessage();
    }

    private String nothingToString() {
        return PlayMessage.NOTHING.toMessage();
    }

    public void gameEnd() {
        System.out.println(PlayMessage.GAME_END.toMessage());
    }

    public void toContinue() {
        System.out.println(PlayMessage.WHETHER_TO_CONTINUE.toMessage());
    }

}