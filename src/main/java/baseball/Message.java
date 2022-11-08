package baseball;

public enum Message {

    NUMBER_BASEBALL_GAME_START("숫자 야구 게임을 시작합니다.\n"),
    NUMBER_BASEBALL_GAME_IS_RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"),
    END_NUMBER_BASEBALL_GAME("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    INPUT_NUMBER("숫자를 입력해주세요 : ");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
