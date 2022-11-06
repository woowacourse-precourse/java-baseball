package baseball;

import baseball.message.Message;

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
        boolean isGameOver = false;
        Balls computerBalls = computer.createBalls();

        while (!isGameOver) {
            Balls playerBalls = player.createBalls();

            Result result = computerBalls.makeResult(playerBalls);
            displayResult(result);
            isGameOver = result.checkGameOver();
        }
    }

    private void displayResult(Result result) {
        Message.printLineMessage(result.toString());
    }

    private boolean isGameContinue() {
        // 유저에게 입력받아 판별
        return true;
    }
}
