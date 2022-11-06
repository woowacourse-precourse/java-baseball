package baseball.domain;

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
        boolean result;

        do {
            OutputView.printAnswerInputGuideMessage();

            String guessedAnswer = InputView.getGuessedAnswer();
            user.setGuessedAnswer(guessedAnswer);

            result = score.isWrongAnswer(computer.getAnswer(), user.getGuessedAnswer());
            OutputView.printResult();

        } while (result);
    }
}
