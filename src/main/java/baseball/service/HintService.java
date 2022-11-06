package baseball.service;

import static baseball.type.NumberType.BALL_ZERO;
import static baseball.type.NumberType.NUMBER_SIZE;
import static baseball.type.NumberType.STRIKE_ZERO;

import baseball.domain.Hint;
import baseball.view.OutputView;

public class HintService {
    public static Hint initialize() {
        return new Hint(STRIKE_ZERO, BALL_ZERO);
    }

    public static boolean isAnswer(Hint hint) {
        int strike = hint.getStrike();

        return strike == NUMBER_SIZE;
    }

    public static void printHint(Hint hint) {
        OutputView.printHint(hint);
    }
}
