package baseball.constant;

public enum GameProcedureConstantString {
    GAME_START_MESSAGE("숫자 야구 게임을 시작합니다.");

    private String stringMessage;

    GameProcedureConstantString(String stringMessage) {
        this.stringMessage = stringMessage;
    }

    public String getStringMessage() {
        return stringMessage;
    }
}
