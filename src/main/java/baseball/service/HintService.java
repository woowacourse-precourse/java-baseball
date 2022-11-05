package baseball.service;

import static baseball.type.GameType.NO_ANSWER;
import static baseball.type.GameType.YES_ANSWER;
import static baseball.type.NumberType.*;

import baseball.domain.Hint;

public class HintService {
    public static Hint initialize() {
        return new Hint(STRIKE_ZERO, BALL_ZERO);
    }

    public static boolean isAnswer(Hint hint) {
        int strike = hint.getStrike();

        if (strike == NUMBER_SIZE) {
            return YES_ANSWER;
        }
        return NO_ANSWER;
    }
}
