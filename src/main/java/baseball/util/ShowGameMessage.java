package baseball.util;

public class ShowGameMessage {
    private boolean isFirstTurn = true;

    public void gameStartMessage() {
        if (isFirstTurn) {
            System.out.println(GameMessage.START);
            isFirstTurn = false;
        }
    }

    public void inputUserNumberMessage() {
        System.out.print(GameMessage.USER_INPUT);
    }
}
