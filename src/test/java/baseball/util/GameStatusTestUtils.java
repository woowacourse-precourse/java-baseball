package baseball.util;

import java.util.Arrays;

public final class GameStatusTestUtils {

    private GameStatusTestUtils() {
    }

    public static GameStatus findGameStatusByName(String name) {
        return Arrays.stream(GameStatus.values())
                .filter(gameStatus -> gameStatus.name().equals(name))
                .findAny().orElseThrow();
    }
}
