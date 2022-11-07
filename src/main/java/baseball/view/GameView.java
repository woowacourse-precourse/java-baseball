package baseball.view;

public class GameView {
    public void printStart() {
        System.out.println(SystemMessage.GAME_START.getMessage());
    }

    public void printAskingForPlayerInput() {
        System.out.print(SystemMessage.ASK_FOR_INPUT.getMessage());
    }

    public void printBall(int ballCount) {
        System.out.println(ballCount + SystemMessage.BALL.getMessage());
    }

    public void printStrike(int strikeCount) {
        System.out.println(strikeCount + SystemMessage.STRIKE.getMessage());
    }

    public void printBallAndStrike(int ballCount, int strikeCount) {
        System.out.println(ballCount + SystemMessage.BALL.getMessage() + " "
                + strikeCount + SystemMessage.STRIKE.getMessage());
    }

    public void printNothing() {
        System.out.println(SystemMessage.NOTHING.getMessage());
    }

    public void printSuccess() {
        System.out.println(SystemMessage.SUCCESS.getMessage());
    }

    public void printRestartOrStop() {
        System.out.println(SystemMessage.RESTART_OR_STOP.getMessage());
    }
}
