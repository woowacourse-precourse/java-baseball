package baseball.infrastructure.hint;

import baseball.domain.hint.Hint;
import baseball.domain.hint.service.HintMessenger;
import baseball.global.utils.message.HintMessage;
import baseball.global.utils.message.Number;

public class NothingMessenger implements HintMessenger {

    @Override
    public boolean support(Hint hint) {
        return hint.getStrike() == Number.ZERO && hint.getBall() == Number.ZERO;
    }

    @Override
    public void printMessage(Hint hint) {
        System.out.println(HintMessage.NOTHING);
    }
}
