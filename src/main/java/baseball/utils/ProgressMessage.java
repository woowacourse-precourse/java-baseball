package baseball.utils;

public enum ProgressMessage {
    PROGRESS_INIT("숫자 야구 게임을 시작합니다."),
    PROGRESS_INPUT_NUMBER("숫자를 입력해주세요 : "),
    PROGRESS_END_GAME("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    ProgressMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }

}
