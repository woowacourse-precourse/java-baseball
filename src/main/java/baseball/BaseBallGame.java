package baseball;

public class BaseBallGame {
    public void startGame() {
        printStartMessage();
    }

    private void printStartMessage() {
        System.out.println(GameMessage.START.getText());
    }
}
