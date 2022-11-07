package baseball.referee;

import baseball.baesball.Baseball;
import baseball.hint.Hint;
import baseball.hint.HintGenerator;

import static baseball.game.GameRule.BASEBALL_STRIKE_WIN_COUNT;
import static baseball.hint.HintType.STRIKE;
import static baseball.referee.JudgeType.GAME_LOSE;
import static baseball.referee.JudgeType.GAME_WIN;

public class Referee {
    private final HintGenerator hintGenerator;
    private final Megaphone megaphone;

    public Referee(HintGenerator hintGenerator, Megaphone megaphone) {
        this.hintGenerator = hintGenerator;
        this.megaphone = megaphone;
    }

    public void announceStartGame() {
        megaphone.speakGameStart();
    }

    public void announcePlayerToStart() {
        megaphone.speakToInputNumbers();
    }

    public JudgeType judgeFrom(Baseball computer, Baseball player) {
        Hint hint = hintGenerator.generate(computer, player);
        JudgeType judgeType = GAME_LOSE;
        if (judgeWin(hint)) {
            judgeType = GAME_WIN;
        }
        megaphone.speakJudgement(judgeType, hint);
        return judgeType;
    }

    private boolean judgeWin(Hint hint) {
        int strikeCount = hint.findCountBy(STRIKE);
        return strikeCount == BASEBALL_STRIKE_WIN_COUNT.getRule();
    }
}
