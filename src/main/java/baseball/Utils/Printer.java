package baseball.Utils;

import baseball.Message.PlayMessage;

public class Printer {

    public void gameStart() {
        System.out.println(PlayMessage.GAME_START.toMessage());
    }

    public void inputNumbers() {
        System.out.print(PlayMessage.INPUT_NUMBERS.toMessage());
    }

    public void countBall(int ballCount, int strikeCount) {
        String result;

        if (ballCount > 0 && strikeCount == 0) {
            result = ball(ballCount);
        } else if (strikeCount > 0 && ballCount == 0) {
            result = strike(strikeCount);
        } else if (ballCount > 0 && strikeCount > 0) {
            result = ball(ballCount) + " " + strike(strikeCount);
        } else {
            result = nothing();
        }

        System.out.println(result);
    }

    private String strike(int count) {
        return String.valueOf(count) + PlayMessage.STRIKE.toMessage();
    }

    private String ball(int count) {
        return String.valueOf(count) + PlayMessage.BALL.toMessage();
    }

    private String nothing() {
        return PlayMessage.NOTHING.toMessage();
    }

    public void gameEnd() {
        System.out.println(PlayMessage.GAME_END.toMessage());
    }

    public void toContinue() {
        System.out.println(PlayMessage.WHETHER_TO_CONTINUE.toMessage());
    }

}