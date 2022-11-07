package baseball;

enum Message {
    GREETING("숫자 야구 게임을 시작합니다."),
    PROMPT_FOR_NUMBER("숫자를 입력해주세요 : "),
    CONGRATULATIONS(Play.getCount() + "개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    PROMPT_PLAY_ON("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;
    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
