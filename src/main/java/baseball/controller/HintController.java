package baseball.controller;

import static baseball.type.GameType.NO_ANSWER;
import static baseball.type.GameType.YES_ANSWER;
import static baseball.type.NumberType.NUMBER_SIZE;

import baseball.domain.Hint;

public class HintController {

    public static boolean isAnswer(Hint hint) {
        int strike = hint.getStrike();

        if (strike == NUMBER_SIZE) {
            return YES_ANSWER;
        }
        return NO_ANSWER;
    }
}
