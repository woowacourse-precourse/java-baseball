package baseball;

public class Game {

    private Computer computer;
    private User user;

    Game() {
        computer = new Computer();
        user = new User();
    }

    public void printStart() {

    }

    public void startGame() {
    }

    public boolean isFinishGame() {
        return false;
    }
}
