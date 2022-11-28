package baseball.model.game;

import baseball.util.GameNumberConst;
import baseball.util.GameResultMessage;

public class GameResult {

    private final int ballCnt;
    private final int strikeCnt;

    public GameResult(int ballCnt, int strikeCnt) {
        this.ballCnt = ballCnt;
        this.strikeCnt = strikeCnt;
    }

    public String getMessage() {
        if (ballCnt > 0 && strikeCnt == 0) {
            return String.format(GameResultMessage.ONLY_BALL, ballCnt);
        }
        if (ballCnt == 0 && strikeCnt > 0) {
            return String.format(GameResultMessage.ONLY_STRIKE, strikeCnt);
        }
        if (ballCnt > 0 && strikeCnt > 0) {
            return String.format(GameResultMessage.BALL_STRIKE, ballCnt, strikeCnt);
        }
        return GameResultMessage.NOTHING;
    }

    public boolean isAllStrike() {
        return strikeCnt == GameNumberConst.NUMBER_SIZE;
    }

    @Override
    public boolean equals(Object otherObj) {
        if (otherObj instanceof GameResult) {
            GameResult other = (GameResult) otherObj;
            return (this.ballCnt == other.ballCnt) && (this.strikeCnt == other.strikeCnt);
        }
        return false;
    }
}
