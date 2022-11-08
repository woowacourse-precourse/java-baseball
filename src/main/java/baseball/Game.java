package baseball;

import util.Constants;

public class Game {

    private Computer computer;
    private User user;

    Game() {
        computer = new Computer();
        user = new User();
    }

    public void printStart() {
        System.out.println(Constants.GAME_START);
    }

    public void startGame() {
    }

    public boolean isFinishGame() {
        return false;
    }
}
