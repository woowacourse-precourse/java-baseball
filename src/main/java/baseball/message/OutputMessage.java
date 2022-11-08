package baseball.message;

import basedomain.message.Message;

public enum OutputMessage implements Message {
    START_MESSAGE("숫자 야구 게임을 시작합니다.\n"),
    CORRECT_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
