package baseball.message;

import basedomain.message.Message;

public enum InputRequestMessage implements Message {
    ASK_APPLICATION_RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"),
    ASK_INPUT_INTEGER("숫자를 입력해주세요 : ");

    private String message;

    InputRequestMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
