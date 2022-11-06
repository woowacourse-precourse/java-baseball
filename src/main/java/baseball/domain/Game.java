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

        Integer[] answer = computer.getAnswer();
        boolean isWorngAnswer;

        do {
            OutputView.printAnswerInputGuideMessage();

            String stringGuessedAnswer = InputView.getGuessedAnswer();
            user.setGuessedAnswer(stringGuessedAnswer);

            Integer[] guessedAnswer = user.getGuessedAnswer();
            isWorngAnswer = score.isWrongAnswer(answer, guessedAnswer);

            OutputView.printResult();

        } while (isWorngAnswer);
    }
}
