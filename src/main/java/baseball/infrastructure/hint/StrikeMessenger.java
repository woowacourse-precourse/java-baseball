package baseball.infrastructure.hint;

import baseball.domain.hint.Hint;
import baseball.domain.hint.service.HintMessenger;
import baseball.global.utils.message.HintMessage;
import baseball.global.utils.message.Number;
import baseball.global.utils.message.TextMessage;

public class StrikeMessenger implements HintMessenger {

    @Override
    public boolean support(Hint hint) {
        return hint.getStrike() == Number.THREE;
    }

    @Override
    public void printMessage(Hint hint) {
        System.out.println(HintMessage.THREE_STRIKE);
        System.out.println(TextMessage.ANSWER);
    }

}
