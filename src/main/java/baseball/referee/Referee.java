package baseball.referee;

import baseball.hint.Hint;
import baseball.hint.HintGenerator;

import static baseball.hint.HintType.*;
import static baseball.referee.GameRule.BASEBALL_STRIKE_WIN_COUNT;
import static baseball.referee.JudgeType.GAME_LOSE;
import static baseball.referee.JudgeType.GAME_WIN;

public class Referee {
    private final HintGenerator hintGenerator;

    public Referee(HintGenerator hintGenerator) {
        this.hintGenerator = hintGenerator;
    }

    public JudgeType judgeBy(Hint hint) {
        int strikeCount = judgeStrikeBy(hint);
        int ballCount = judgeBallBy(hint);
        int nothingCount = judgeNothingBy(hint);

        if (strikeCount == BASEBALL_STRIKE_WIN_COUNT.getRule()) {
            return GAME_WIN;
        }
        return GAME_LOSE;
    }

    public int judgeStrikeBy(Hint hint) {
        return (int) hint.getHints()
                .stream()
                .filter(hintType -> hintType == STRIKE)
                .count();
    }

    public int judgeBallBy(Hint hint) {
        return (int) hint.getHints()
                .stream()
                .filter(hintType -> hintType == BALL)
                .count();
    }

    public int judgeNothingBy(Hint hint) {
        return (int) hint.getHints()
                .stream()
                .filter(hintType -> hintType == NOTHING)
                .count();
    }
}
