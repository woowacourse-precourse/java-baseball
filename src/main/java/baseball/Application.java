package baseball;

import baseball.game.Computer;
import baseball.game.Player;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        Computer computer = new Computer();
        Player player = new Player();
        computer.startGame();
        List<Integer> integers = player.inputPlayerNumber();
    }
}
