package baseball;

import java.util.Arrays;

public enum GameStatus {
    RESTART("1"), GAME_OVER("2");

    private final String value;

    GameStatus(String value) {
        this.value = value;
    }

    public static GameStatus findGameStatus(String input) {
        return Arrays.stream(values())
                .filter(gameStatus -> gameStatus.value.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 값이 입력되었습니다."));
    }
}
