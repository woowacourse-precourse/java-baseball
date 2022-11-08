package baseball.game;

import baseball.domain.CompareResult;

public class GameStatus {

    private static final boolean GAME_END = true;

    private static final boolean GAME_CONTINUE = false;

    private boolean status;

    public GameStatus() {
        this.status = GAME_CONTINUE;
    }

    public void setStatus(final CompareResult compareResult) {
        if (compareResult.isAllStrikes()) {
            status = GAME_END;
        }
    }

    public boolean isGameEnd() {
        return this.status == GAME_END;
    }

    public void initStatus() {
        this.status = GAME_CONTINUE;
    }
}
