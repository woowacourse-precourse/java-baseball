package baseball.controller;

import baseball.model.Answer;
import baseball.model.RandomNumGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import baseball.vo.Score;

public class BaseballGame {
    public static final int RESTART = 1;

    public BaseballGame() {
        OutputView.printGameStart();
    }

    public void gameStart() {
        Answer answer = new Answer(RandomNumGenerator.generate());
        guessAnswer(answer);
        if (InputView.inputRestartOrExitNumber() == RESTART) {
            gameStart();
        }
    }

    public void guessAnswer(Answer answer) {
        Score userScore = answer.compare(InputView.inputGuessThreeNumbers());
        OutputView.printResult(userScore);
        if (answer.isUserCorrect(userScore)) {
            OutputView.printGameEnd();
        } else if (!answer.isUserCorrect(userScore)) {
            guessAnswer(answer);
        }
    }
}
