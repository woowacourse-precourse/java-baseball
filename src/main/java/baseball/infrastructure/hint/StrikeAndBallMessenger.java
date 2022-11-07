package baseball.infrastructure.hint;

import baseball.domain.hint.Hint;
import baseball.domain.hint.HintMessenger;
import baseball.global.utils.message.HintMessage;
import baseball.global.utils.message.Number;

public class StrikeAndBallMessenger implements HintMessenger {

    @Override
    public boolean support(Hint hint) {
        return (hint.getStrike() > Number.ZERO && hint.getStrike() < Number.THREE) &&
                (hint.getBall() > Number.ZERO && hint.getBall() < Number.THREE);
    }

    @Override
    public void printMessage(Hint hint) {
        System.out.println(HintMessage.StrikeAndBall(hint));
    }
}
