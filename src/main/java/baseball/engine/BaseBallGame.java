package baseball.engine;

import baseball.io.ConsoleInput;
import baseball.io.ConsoleOutput;
import baseball.model.BallStatus;
import baseball.model.Numbers;

public class BaseBallGame implements Runnable {

    private final ConsoleOutput output;
    private final ConsoleInput input;
    private final BaseBallGameEngine engine;

    public BaseBallGame(ConsoleOutput output, ConsoleInput input, BaseBallGameEngine engine) {
        this.output = output;
        this.input = input;
        this.engine = engine;
    }

    @Override
    public void run() {
        output.printStartText();
        Numbers answer = engine.generateAnswer();

        while (true) {
            String userInputNumber = input.inputNumber();
            Numbers userNumber = engine.parseToNumbers(userInputNumber);
            BallStatus ballStatus = engine.createBallStatus(answer, userNumber);
            output.printScore(ballStatus);

            if (engine.isNotCorrect(ballStatus)) {
                continue;
            }

            output.printEndText(ballStatus);
            String choice = input.userInput();

            if (engine.isExitGame(choice)) {
                break;
            }

            answer = engine.generateAnswer();
        }
    }
}
