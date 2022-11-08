package baseball.application;

import baseball.model.Answer;
import baseball.model.Result;
import baseball.ui.InputUtil;
import baseball.ui.OutputUtil;
import baseball.ui.ShortCut;

public class BaseballGame implements Game {
    @Override
    public void run() {
        Answer targetAnswer = Answer.create();

        boolean isCorrectAnswer = false;

        while (!isCorrectAnswer) {
            Answer inputAnswer = Answer.fromString(InputUtil.inputAnswer());

            Result result = Result.getResult(targetAnswer, inputAnswer);

            OutputUtil.printResult(result);
            
            isCorrectAnswer = result.isCorrectAnswer();
        }
    }

    @Override
    public boolean selectContinueYn() {
        return ShortCut.END_GAME.getValue()
                .equals(
                        InputUtil.inputContinueGame()
                );
    }
}
