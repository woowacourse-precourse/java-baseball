package baseball.view;

public class Display {
    private Display() {
    }

    public static Display getInstance() {
        return new Display();
    }

    public void printStartGame() {
        System.out.println(ViewConstants.START_GAME);
    }

    public void printInputOffenseNumber() {
        System.out.print(ViewConstants.INPUT);
    }

    public void printThreeStrike() {
        System.out.println(ViewConstants.THREE_STRIKE);
    }

    public void printNothing() {
        System.out.println(ViewConstants.NOTHING);
    }

    public void printBallOnly(int ballCount) {
        System.out.println(String.format(ViewConstants.BALL, ballCount));
    }

    public void printStrikeOnly(int strikeCount) {
        System.out.println(String.format(ViewConstants.STRIKE, strikeCount));
    }

    public void printBallAndStrike(int ballCount, int strikeCount) {
        System.out.println(String.format(ViewConstants.BALL_AND_STRIKE, ballCount, strikeCount));
    }

    public void printContinueGame() {
        System.out.println(ViewConstants.CONTINUE_GAME);
    }
}
