package baseball.domain;

import java.util.Arrays;

public enum GameStatus {
    RESTART(1, true),
    END(2, false);

    private int inputNumber;
    private boolean isRestart;

    GameStatus(int inputNumber, boolean isRestart) {
        this.inputNumber = inputNumber;
        this.isRestart = isRestart;
    }

    public boolean isRestart() {
        return isRestart;
    }

    public static GameStatus getGameStatus(int number) {
        return Arrays.stream(GameStatus.values())
                .filter(status -> status.inputNumber == number)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("입력하신 숫자는 없는 숫자입니다"));
    }

}
