package baseball.service;

import static baseball.type.HintType.BALL_ZERO;
import static baseball.type.HintType.STRIKE_ZERO;
import static baseball.type.NumberType.NUMBER_SIZE;

import baseball.domain.Hint;
import baseball.view.OutputView;

public class HintService {
    public static Hint initialize() {
        return new Hint(STRIKE_ZERO.getValue(), BALL_ZERO.getValue());
    }

    public static boolean isAnswer(Hint hint) {
        int strike = hint.getStrike();

        return strike == NUMBER_SIZE.getValue();
    }

    public static void printHint(Hint hint) {
        OutputView.printHint(hint);
    }
}
