package baseball.controller;

import static baseball.view.InputValidator.INPUT_LENGTH;

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
        whileUserInputCorrectAnswer(answer);
        if (InputView.inputRestartOrExitNumber() == RESTART) {
            gameStart();
        }
    }

    public void whileUserInputCorrectAnswer(Answer answer) {
        while (true) {
            Score userScore = answer.compare(InputView.inputGuessThreeNumbers());
            OutputView.printResult(userScore);
            if (userScore.getStrike() == INPUT_LENGTH) {
                OutputView.printGameEnd(userScore);
                break ;
            }
        }
    }
}
