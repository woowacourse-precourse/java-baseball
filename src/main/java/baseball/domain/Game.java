package baseball.domain;

import baseball.validator.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {
    private final User user;
    private final Computer computer;
    private final Score score;

    public Game() {
        this.user = new User();
        this.computer = new Computer();
        this.score = new Score();
    }

    public void start() {
        OutputView.printGameStartMessage();
        computer.generateAnswer();

        Integer[] answer = computer.getAnswer();
        boolean isWrongAnswer;

        do {
            OutputView.printAnswerInputGuideMessage();

            String stringGuessedAnswer = InputView.getGuessedAnswer();
            InputValidator.validateInputForm(stringGuessedAnswer);
            user.setGuessedAnswer(stringGuessedAnswer);

            Integer[] guessedAnswer = user.getGuessedAnswer();
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
        if (command.equals("1")) {
            start();
        }
    }
}
