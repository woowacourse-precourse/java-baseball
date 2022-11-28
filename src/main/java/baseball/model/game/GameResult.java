package baseball.model.game;

import baseball.exception.WrongGameResultException;
import baseball.util.GameNumberConst;
import baseball.util.GameResultMessage;

public class GameResult {

    private final int ballCnt;
    private final int strikeCnt;

    public GameResult(int ballCnt, int strikeCnt) {
        validate(ballCnt, strikeCnt);
        this.ballCnt = ballCnt;
        this.strikeCnt = strikeCnt;
    }

    private static void validate(int ballCnt, int strikeCnt) {
        if (notInRange(ballCnt)
                || notInRange(strikeCnt)
                || nonExists(ballCnt, strikeCnt)) {
            throw new WrongGameResultException();
        }
    }

    private static boolean notInRange(int cnt) {
        return (cnt < 0) || (cnt > GameNumberConst.NUMBER_SIZE);
    }

    private static boolean nonExists(int ballCnt, int strikeCnt) {
        return (ballCnt + strikeCnt > GameNumberConst.NUMBER_SIZE) || (ballCnt == 1 && strikeCnt == 2);
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
