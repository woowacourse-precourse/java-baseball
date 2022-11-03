package baseball;

import baseball.view.GameMessage;

public class Baseball {
    private GameMessage gameMessage = new GameMessage();
    private User user = new User();
    private Computer computer = new Computer();

    public void playGame() {
        gameMessage.startGame();

        computer.throwTheBall();
        user.hitTheBall();
    }
}
