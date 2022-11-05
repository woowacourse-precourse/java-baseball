package baseball.domain.step;

import baseball.application.context.BaseBallGameContext;
import baseball.application.io.Writer;
import baseball.domain.comparator.Comparator;
import baseball.domain.computer.Computer;
import baseball.domain.player.Player;
import baseball.domain.result.CompareResult;

public class GameProgressStep implements Step {

    private static final Step ANSWER_STEP = new GameEndStep();

    private static final Step WRONG_ANSWER_STEP = new InputNumberStep();

    private Step next = WRONG_ANSWER_STEP;

    @Override
    public void execute(BaseBallGameContext context) {
        Player player = context.player();
        Computer computer = context.computer();
        Comparator comparator = context.comparator();

        CompareResult compareResult =
                comparator.compare(player.baseBallGameNumbers(), computer.baseBallGameNumbers());

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
