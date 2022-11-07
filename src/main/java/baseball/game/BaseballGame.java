package baseball.game;

import baseball.input.FinishInput;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final GamePrinter printer;
    private final GameResultCalculator calculator;
    protected Number answerNumber;
    private Number playerInputNumber;
    private GameState gameState;

    public BaseballGame() {
        printer = new GamePrinter();
        calculator = new GameResultCalculator();
    }


    public void start() {
        generateRandomNumber();

        printer.printStartMessage();
        gameState = GameState.START;
    }

    public void play() {
        do {
            printer.printInputPrompt();
            readPlayerInput();
            List<Integer> result = calculateResult();
            printer.printResult(result);
        } while (!calculator.isThreeStrike(answerNumber, playerInputNumber));
    }

    public void pause() {
        printer.printPauseMessage();
        gameState = GameState.PAUSE;

        if (readFinishInput() == FinishInput.QUIT_GAME) {
            end();
        }
    }

    public boolean isEnd() {
        return gameState == GameState.END;
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

    private void readPlayerInput() {
        String line = Console.readLine();
        int input = Integer.parseInt(line);
        playerInputNumber = new Number(input);
    }

    private List<Integer> calculateResult() {
        int ballCount = calculator.countBall(answerNumber, playerInputNumber);
        int strikeCount = calculator.countStrike(answerNumber, playerInputNumber);
        return List.of(ballCount, strikeCount);
    }


    private FinishInput readFinishInput() {
        int inputNumber = Integer.parseInt(Console.readLine());
        return FinishInput.numberOf(inputNumber);
    }

    private void end() {
        gameState = GameState.END;
        printer.printEndMessage();
    }
}
