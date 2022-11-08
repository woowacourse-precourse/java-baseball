package baseball;

public enum GameMessage {
    START_GAME("숫자 야구 게임을 시작합니다."),
    QUESTION__NUMBER("숫자를 입력해주세요 : "),
    BALL("볼 "),
    STRIKE("스트라이크"),
    GAME_OVER("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    QUESTION_CONTINUE("게임을 새로 시작하려면 1, 종료하시려면 2를 입력하세요.");

    private final String value;

    GameMessage(String value){
        this.value = value;
    }

    public String getName(){
        return name();
    }

    public String getValue(){
        return value;
    }
}
