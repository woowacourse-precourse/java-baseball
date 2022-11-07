package baseball.infrastructure.hint;

import baseball.domain.hint.Hint;
import baseball.domain.hint.service.HintMessenger;
import baseball.global.utils.message.HintMessage;
import baseball.global.utils.message.Number;

public class BallMessenger implements HintMessenger {

    @Override
    public boolean support(Hint hint) {
        return hint.getBall() == Number.THREE;
    }

    @Override
    public void printMessage(Hint hint) {
        System.out.println(HintMessage.THREE_BALL);
    }
}
