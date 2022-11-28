package baseball.model;

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
}
