package baseball;

import baseball.engine.BaseBallGameEngine;
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
            BallStatus ballStatus = getBallStatus(answer);
            output.printScore(ballStatus);

            if (engine.isNotCorrect(ballStatus)) {
                continue;
            }

            String choice = getUserChoice(ballStatus);

            if (engine.isExitGame(choice)) {
                break;
            }

            answer = engine.generateAnswer();
        }
    }

    private String getUserChoice(BallStatus ballStatus) {
        output.printEndText(ballStatus);

        return input.userInput();
    }

    private BallStatus getBallStatus(Numbers answer) {
        String userInputNumber = input.inputNumber();
        Numbers userNumber = engine.parseToNumbers(userInputNumber);

        return engine.createBallStatus(answer, userNumber);
    }
}
