package baseball;

enum GameMessage {
    START("숫자 야구 게임을 시작합니다"),
    CORRECT("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    REPLAY_OR_END("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    TYPE_USER_GUESS("숫자를 입력해주세요 : "),
    ILLEGAL_ARGUMENT_GUESS_RANGE("입력 숫자 범위는 1~9 여야 합니다."),
    ILLEGAL_ARGUMENT_GUESS_SIZE("입력 숫자는 3개여야 합니다."),
    ILLEGAL_ARGUMENT_GUESS_DUPLICATE("입력 숫자는 중복되선 안됩니다."),
    ILLEGAL_ARGUMENT_OPTION("1 혹은 2를 입력하지 않으셨습니다.");

    private final String message;

    GameMessage(String message){
        this.message = message;
    }

    public String message(){
        return message;
    }
}
