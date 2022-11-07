package baseball;

import java.util.List;
import java.util.Objects;
import ui.Input;
import ui.Output;

public class Game {

    private final int MAX_LEN;

    private ComputerBallsGenerator computer;
    private GameResultJudgement judge;
    private ValidityChecker validityChecker;
    private GameResultConverter converter;

    public Game(int maxLen) {
        this.MAX_LEN = maxLen;
        computer = new ComputerBallsGenerator();
        judge = new GameResultJudgement();
        validityChecker = new ValidityChecker(maxLen);
        converter = new GameResultConverter();
    }

    public void run(Input input, Output output) {
        String toBeContinued;
        output.printStartMessage();
        do {
            play(input, output);
            output.printRequestRestartGameInput();
            toBeContinued = input.scan();
            validityChecker.validateRestartGameInput(toBeContinued);
        } while (Objects.equals(toBeContinued, "1"));
    }

    public void play(Input input, Output output) {
        String computerNumber = computer.ballsGenerator();
        boolean retry;
        do {
            output.printRequestNumberInput();
            String userInputNumber = input.scan();
            validityChecker.validateNumberInput(userInputNumber);
            List<Integer> judgement = judge.judgeStrikeBallNothing(computerNumber, userInputNumber);

            String buffer = converter.convertGameResult(judgement);
            output.printGameResult(buffer);
            retry = isMatch(computerNumber, userInputNumber);
            if (retry) {
                output.printEndGame();
            }
        } while (!retry);
    }

    public boolean isMatch(String computer, String user) {
        return Objects.equals(computer, user);
    }
}
