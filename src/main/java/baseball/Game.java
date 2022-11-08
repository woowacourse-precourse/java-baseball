package baseball;

import java.util.List;

public class Game {
    private List<Integer> computerNumber;

    private void start(Player computer) {
        Print.startGame();
        this.computerNumber = computer.getComputerRandomNumber();
    }
}
