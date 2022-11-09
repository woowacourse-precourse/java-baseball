package baseball.game;

import baseball.domain.CompareResult;

public class GameStatus {

    private boolean isGameEnd;

    public void setStatus(final CompareResult compareResult) {
        if (compareResult.isAllStrikes()) {
            isGameEnd = true;
        }
    }

    public boolean isGameEnd() {
        return this.isGameEnd;
    }

    public void initStatus() {
        isGameEnd = false;
    }
}
