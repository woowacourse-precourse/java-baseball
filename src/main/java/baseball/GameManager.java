package baseball;

import baseball.domain.Balls;
import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Result;
import baseball.input.InputReader;
import baseball.output.OutputViewer;
import baseball.utils.Command;

import static baseball.output.OutputViewer.*;

public class GameManager {

    private final Computer computer;
    private final Player player;
    private final InputReader inputReader;

    public GameManager(Computer computer, Player player, InputReader inputReader) {
        this.computer = computer;
        this.player = player;
        this.inputReader = inputReader;
    }

    public void run() {
        Command command = Command.CONTINUE;

        while (command == Command.CONTINUE) {
            playGame();
            command = checkGameContinue();
        }
    }

    private void playGame() {
        boolean isGameOver = false;
        Balls computerBalls = computer.createBalls();

        while (!isGameOver) {
            printLine(MESSAGE_FOR_START);
            Balls playerBalls = player.createBalls();

            Result result = computerBalls.makeResult(playerBalls);
            displayResult(result);

            isGameOver = result.checkGameOver();
        }

        printLine(MESSAGE_FOR_GAME_OVER);
    }

    private void displayResult(Result result) {
        OutputViewer.printLine(result.toString());
    }

    private Command checkGameContinue() {
        print(MESSAGE_FOR_CONTINUE);
        return Command.of(inputReader.read());
    }
}
