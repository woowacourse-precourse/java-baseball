package baseball.game;

import baseball.input.FinishInput;
import baseball.input.GameInput;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final GamePrinter printer;
    private final GameResultCalculator calculator;
    protected Number randomNumber;
    private GameInput playerInput;
    private State state;

    public BaseballGame() {
        printer = new GamePrinter();
        calculator = new GameResultCalculator();
    }


    public void start() {
        generateRandomNumber();

        printer.printStartMessage();
        state = State.START;
    }

    public void play() {
        do {
            printer.printInputPrompt();
            readPlayerInput();
            List<Integer> result = calculateResult();
            printer.printResult(result);
        } while (!calculator.isThreeStrike(randomNumber, playerInput.number));
    }

    public void pause() {
        printer.printPauseMessage();
        state = State.PAUSE;

        if (readFinishInput() == FinishInput.QUIT_GAME) {
            end();
        }
    }

    public boolean isEnd() {
        return state == State.END;
    }

    private void generateRandomNumber() {
        List<Integer> digits = new ArrayList<>();
        while (digits.size() < Number.FULL_SIZE) {
            addUniqueRandomDigit(digits);
        }
        randomNumber = new Number(digits);
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
        playerInput = new GameInput(input);
    }

    private List<Integer> calculateResult() {
        int ballCount = calculator.countBall(randomNumber, playerInput);
        int strikeCount = calculator.countStrike(randomNumber, playerInput);
        return List.of(ballCount, strikeCount);
    }


    private FinishInput readFinishInput() {
        int inputNumber = Integer.parseInt(Console.readLine());
        return FinishInput.numberOf(inputNumber);
    }

    private void end() {
        state = State.END;
        printer.printEndMessage();
    }
}
