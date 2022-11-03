package baseball;

public class GameManager {

    private final Computer computer;

    public GameManager(Computer computer) {
        this.computer = computer;
    }

    public void run() {
        do {
            playGame();
        } while (isGameContinue());
    }

    private void playGame() {
        computer.createBalls();
    }

    private boolean isGameContinue() {
        // 유저에게 입력받아 판별
        return true;
    }
}
