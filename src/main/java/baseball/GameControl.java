package baseball;

import java.util.*;

public class GameControl {

    private List<Integer> computer;
    private List<Integer> player;

    public GameControl() {}

    public void startGame() {
        Computer computerNumber = new Computer();
        Player playerNumber = new Player();

        computerNumber.setNumbers();
        this.computer = computerNumber.getNumbers();

        playerNumber.setNumbers();
        this.player = playerNumber.getNumbers();
    }
}
