package baseball;

import java.util.*;

public class GameControl {

    private List<Integer> computer;
    private ArrayList<Integer> player;

    public GameControl() {}

    public void startGame() {
        Computer computerNumber = new Computer();
        Player playerNumber = new Player();

        computerNumber.setNumbers();
        computer = computerNumber.getNumbers();
    }
}
