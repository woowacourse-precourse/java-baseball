package baseball.domain.step;

import baseball.application.context.BaseBallGameContext;
import baseball.application.io.Writer;
import baseball.application.random.Range;

public class GameEndStep implements Step{

    private static final String RIGHT_ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private static final Step NEXT = new DetermineRestartGameStep();

    @Override
    public void execute(BaseBallGameContext context) {
        Writer writer = context.writer();

        writer.println(RIGHT_ANSWER_MESSAGE);
    }

    @Override
    public Step next() {
        return NEXT;
    }

    @Override
    public boolean executable() {
        return true;
    }
}
