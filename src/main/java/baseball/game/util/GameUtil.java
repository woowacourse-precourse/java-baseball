package baseball.game.util;

import baseball.console.Interactive;

public class GameUtil implements Interactive {

    private static final GameUtil instance = new GameUtil();
    public static final Integer STRIKE_OUT_COUNT = 3;
    public static final Integer NUMBER_SIZE = 3;

    public static GameUtil getInstance() {
        return instance;
    }

    @Override
    public Integer getUserInput() {
        return 0;
    }
}
