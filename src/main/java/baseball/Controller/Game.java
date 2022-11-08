package baseball.Controller;

import static baseball.Constant.*;

import baseball.Controller.Controller;
import baseball.Model.Computer;
import baseball.Model.Player;

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
        while(computer.strike != 3) {
            System.out.print(GAME_GUESS);
            computer.judge(player.inputGuess());
        }
        System.out.println(GAME_SUCCESS);
    }

    public void replayGame() throws IllegalArgumentException {
        System.out.println(GAME_RETRY);
        boolean replay = player.inputRetry();
        if(replay) {
            Controller controller = new Controller();
            controller.run();
        }
    }
}
