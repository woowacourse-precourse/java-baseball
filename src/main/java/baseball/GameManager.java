package baseball;

public class GameManager {

    private final Computer computer;
    private final Player player;

    public GameManager(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public void run() {
        do {
            playGame();
        } while (isGameContinue());
    }

    private void playGame() {
        computer.createBalls();

        while (checkGameOver()) {
            player.createBalls();
        }
    }

    private boolean checkGameOver() {
    }

    private boolean isGameContinue() {
        // 유저에게 입력받아 판별
        return true;
    }
}
