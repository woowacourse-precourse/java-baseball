package baseball.Controller;

import baseball.Model.Computer;
import baseball.Model.Player;
import baseball.View.Message;

public class Game {
    Computer computer;
    Player player;

    public Game() {
        computer = new Computer();
        player = new Player();
    }

    public void initGame() {
        computer.randNumber();
    }

    public void playGame() throws IllegalArgumentException {
        while(computer.strikeCount != 3) {
            Message.printGuessMessage();
            computer.judge(player.inputGuess());
        }
        Message.printSuccessMessage();
    }

    public void replayGame() throws IllegalArgumentException {
        Message.printRetryMessage();
        boolean replay = player.inputRetry();
        if(replay) {
            Controller controller = new Controller();
            controller.run();
        }
    }
}
