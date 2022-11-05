package baseball.domain.step;

import baseball.application.context.BaseBallGameContext;
import baseball.domain.result.CompareResult;

public class GameProgressStep implements Step {

    private static final Step ANSWER_STEP = new GameEndStep();

    private static final Step WRONG_ANSWER_STEP = new InputNumberStep();

    private Step next = WRONG_ANSWER_STEP;

    @Override
    public void execute(BaseBallGameContext context) {
        CompareResult compareResult = context.comparePlayerAndComputer();

        context.println(compareResult.toString());

        if (compareResult.isAnswer()) {
            next = ANSWER_STEP;
            return;
        }
        next = WRONG_ANSWER_STEP;
    }

    @Override
    public Step next() {
        return next;
    }

    @Override
    public boolean executable() {
        return true;
    }
}
