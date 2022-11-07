package baseball.domain.step;

import baseball.application.context.BaseBallGameContext;
import baseball.domain.number.BaseBallGameNumbers;

public class InputNumberStep implements Step {

    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    private static final Step NEXT = new GameProgressStep();

    @Override
    public void execute(BaseBallGameContext context) {
        context.print(INPUT_NUMBER_MESSAGE);

        context.changePlayerNumbers(new BaseBallGameNumbers(context.readLine()));
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
