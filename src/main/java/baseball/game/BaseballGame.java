package baseball.game;

import baseball.game.input.FinishInput;
import baseball.game.number.Number;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final GamePrinter printer;
    private final GameScanner scanner;
    private final GameResultCalculator calculator;
    protected Number answerNumber;
    private GameState gameState;

    public BaseballGame() {
        printer = new GamePrinter();
        scanner = new GameScanner();
        calculator = new GameResultCalculator();
    }

    public void start() {
        generateRandomNumber();

        printer.printStartMessage();
        gameState = GameState.START;
    }

    public void play() {
        Number playerInputNumber;
        do {
            printer.printInputPrompt();
            playerInputNumber = scanner.readPlayerNumber();
            GameResult result = calculator.makeGameResult(answerNumber, playerInputNumber);
            printer.printResult(result);
        } while (!calculator.isThreeStrike(answerNumber, playerInputNumber));
    }

    public void pause() {
        printer.printPauseMessage();
        gameState = GameState.PAUSE;

        if (scanner.readFinishInput() == FinishInput.QUIT_GAME) {
            end();
        }
    }

    public boolean isEnd() {
        return gameState == GameState.END;
    }

    private void end() {
        gameState = GameState.END;
        printer.printEndMessage();
    }

    private void generateRandomNumber() {
        List<Integer> digits = new ArrayList<>();
        while (digits.size() < Number.FULL_SIZE) {
            addUniqueRandomDigit(digits);
        }
        answerNumber = new Number(digits);
    }

    private void addUniqueRandomDigit(List<Integer> digits) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!digits.contains(randomNumber)) {
            digits.add(randomNumber);
        }
    }
}
