package baseball;

public abstract class Message {

    public final static String GAME_START = "숫자 야구 게임을 시작합니다.";
    public final static String REQUEST_NUMBER = "숫자를 입력해주세요 : ";
    public final static String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public final static String RESTART_OR_EXIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public final static String STRIKE = "스트라이크";
    public final static String BALL = "볼";
    public final static String NOT_THING = "낫싱";
}
