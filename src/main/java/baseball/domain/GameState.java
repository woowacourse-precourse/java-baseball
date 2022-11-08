package baseball.domain;

import java.util.Arrays;

public enum GameState {

    KEEP_PLAY(0), RESTART(1), EXIT(2);

    private final int gameState;

    private GameState(int gameState) {
        this.gameState = gameState;
    }

    public static GameState init() {
        return GameState.KEEP_PLAY;
    }

    public boolean isNotPlayable() {
        return this == EXIT;
    }

    public boolean isPlayable() {
        return this != EXIT;
    }

    public boolean isRestart() {
        return this == RESTART;
    }

    public static GameState findGameState(int gameState) {
        return Arrays.stream(values())
                .filter(state -> state.isMatch(gameState))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("입력(%d)과 일치하는 상태값을 찾을 수 없습니다.", gameState)));
    }

    private boolean isMatch(int gameState) {
        return this.gameState == gameState;
    }
}
