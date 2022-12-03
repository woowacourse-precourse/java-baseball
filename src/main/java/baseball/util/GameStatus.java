package baseball.util;

import baseball.Baseball;

public enum GameStatus {
    BALL_SIZE(3),
    GAME_STATUS_SIZE(1);

    private final int initInfo;

    GameStatus(int num) {
        this.initInfo = num;
    }

    public int getInitInfo() {
        return initInfo;
    }
}
