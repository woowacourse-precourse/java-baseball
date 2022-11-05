package baseball.constant;

public enum GameProcedureConstantString {
    GAME_START_MESSAGE("숫자 야구 게임을 시작합니다."),
    USER_SIDE_BASEBALL_CREATE_MESSAGE("숫자를 입력해주세요 : "),
    THIS_TURN_FINISH_GAME_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    private String stringMessage;

    GameProcedureConstantString(String stringMessage) {
        this.stringMessage = stringMessage;
    }

    public String getStringMessage() {
        return stringMessage;
    }
}
