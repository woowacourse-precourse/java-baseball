package baseball.domain;

import baseball.validator.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class Game {

    private static final String RESTART_COMMAND = "1";

    private final User user;
    private final Computer computer;
    private final Score score;

    public Game() {
        user = new User();
        computer = new Computer();
        score = new Score();
    }

    public void start() {
        OutputView.printGameStartMessage();
        computer.generateAnswer();

        List<Integer> answer = computer.getAnswer();
        boolean isWrongAnswer;

        do {
            OutputView.printAnswerInputGuideMessage();

            String stringGuessedAnswer = InputView.getGuessedAnswer();
            InputValidator.validateInputForm(stringGuessedAnswer);
            user.setGuessedAnswer(stringGuessedAnswer);

            List<Integer> guessedAnswer = user.getGuessedAnswer();
            isWrongAnswer = score.isWrongAnswer(answer, guessedAnswer);

            OutputView.printResult();

        } while (isWrongAnswer);

        OutputView.printGameEndMessage();
        OutputView.printRestartOrStopGuideMessage();

        String command = InputView.getRestartOrStopCommand();
        InputValidator.validCommandForm(command);
        reStarOrStop(command);
    }

    public void reStarOrStop(String command) {
        if (command.equals(RESTART_COMMAND)) {
            start();
        }
    }
}
