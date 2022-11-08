package baseball.model;

public class GameStatus {
    public static final String INVALID_GAME_STATUS_INPUT_VALUE_MESSAGE = "게임 상태는 재시작:1, 종료:2 중에서 입력해야 합니다";
    private static final String INVALID_INPUT_TYPE_MESSAGE = "숫자를 입력해주세요.";
    private static final int GAME_RESTART_STATUS = 1;
    private static final int GAME_OVER_STATUS = 2;
    int status;

    public GameStatus(int status) {
        this.status = status;
    }

    public boolean isRestart() {
        return status == GAME_RESTART_STATUS;
    }

    public void validateGameStatusValue(int status) {
        if (status == GAME_RESTART_STATUS || status == GAME_OVER_STATUS) {
            return;
        }
        throw new IllegalArgumentException(INVALID_GAME_STATUS_INPUT_VALUE_MESSAGE);
    }

    public void changeStatus(String playerInput) {
        validateGameStatusValue(status);
        validateParseStringToInt(playerInput);

        this.status = Integer.parseInt(playerInput);
    }

    private void validateParseStringToInt(String playerInput) {
        try {
            Integer.parseInt(playerInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_TYPE_MESSAGE);
        }
    }
}
