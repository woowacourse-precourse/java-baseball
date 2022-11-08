package baseball;

import baseball.input.InputReader;
import baseball.message.Message;
import baseball.utils.Command;

import static baseball.message.Message.*;

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
            printLineMessage(MESSAGE_FOR_START);
            Balls playerBalls = player.createBalls();

            Result result = computerBalls.makeResult(playerBalls);
            displayResult(result);

            isGameOver = result.checkGameOver();
        }

        printLineMessage(MESSAGE_FOR_GAME_OVER);
    }

    private void displayResult(Result result) {
        Message.printLineMessage(result.toString());
    }

    private Command checkGameContinue() {
        printMessage(MESSAGE_FOR_CONTINUE);
        return Command.of(inputReader.read());
    }
}
