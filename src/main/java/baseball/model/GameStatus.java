package baseball.model;

public class GameStatus {
    public static final String INVALID_GAME_STATUS_INPUT_VALUE_MESSAGE = "게임 상태는 재시작:1, 종료:2 중에서 입력해야 합니다";
    private static final String INVALID_INPUT_TYPE_MESSAGE = "숫자를 입력해주세요.";
    int status;

    public GameStatus(int status) {
        this.status = status;
    }

    public boolean isRestart() {
        return status == 1;
    }

    public void validateGameStatusValue(int status) {
        if (status == 1 || status == 2) {
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
