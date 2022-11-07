package baseball.game;

import java.util.Arrays;
import java.util.Optional;

public enum GameStatus {
    GAME_RESTART(1),
    GAME_END(2);

    private final int type;

    GameStatus(int type) {
        this.type = type;
    }

    public static Optional<GameStatus> findGameStatus(int type) {
        return Arrays.stream(GameStatus.values())
                .filter(gameStatus -> gameStatus.type == type)
                .findFirst();
    }

    public int getType() {
        return type;
    }
}
