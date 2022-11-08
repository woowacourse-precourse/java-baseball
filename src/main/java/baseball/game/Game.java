package baseball.game;

import baseball.computer.Computer;
import baseball.player.Player;

import java.util.List;

public class Game {
    public Computer prepareComputer(Computer computer){
        computer.createRandomNumbers();
        return computer;
    }
}
