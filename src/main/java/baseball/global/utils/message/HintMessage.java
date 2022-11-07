package baseball.global.utils.message;

import baseball.domain.hint.Hint;

public interface HintMessage {

    String STRIKE = "스트라이크";
    String BALL = "볼";
    String NOTHING = "낫싱";

    String THREE_STRIKE = Number.THREE + STRIKE;
    String THREE_BALL = Number.THREE + BALL;

    static String StrikeAndBall(Hint hint) {
        return hint.getBall() + BALL + " " + hint.getStrike() + STRIKE;
    }
}
