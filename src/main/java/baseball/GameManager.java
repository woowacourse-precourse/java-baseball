package baseball;

import baseball.domain.Computer;
import baseball.utils.GameState;
import baseball.view.PrintAndRead;

import java.util.List;

public class GameManager {

    private Computer computer;
    private GameState gameState;

    public GameManager(Computer computer) {
        this.computer = computer;
        initiate();
    }

    public void initiate() {
        gameState = GameState.START;
        computer.initiate();
    }

    public void run() {
        PrintAndRead.firstStartPrint();

        while (gameState == GameState.START) {
            List<Integer> question = PrintAndRead.getBaseballNumber();
            printAnswer(question);
            isGameEnd(question);

            if(gameState == GameState.END) {
                restartGame();
            }
        }
    }

    public void printAnswer(List<Integer> question) {
        if (computer.checkNothing(question) == Computer.IS_NOTING) {
            PrintAndRead.printNothing();
            return;
        }

        int strike = computer.checkStrike(question);
        int ball = computer.checkBall(question, strike);
        PrintAndRead.printBallOrStrike(ball, strike);

    }

    public void isGameEnd(List<Integer> question) {
        if (computer.checkGameEnd(question) == true) {
            gameState = GameState.END;
            return;
        }
        gameState = GameState.START;
    }

    public void restartGame() {
        int answer = PrintAndRead.printRestartGame();

        if (answer == 1) {
            initiate();
        }
    }

}
