package baseball;

public enum Message {

    START_GAME("숫자 야구 게임을 시작합니다."),
    INPUT_NUMBER("숫자를 입력해주세요 : "),
    CORRECT_ANSWER("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    String msg;

    Message(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
