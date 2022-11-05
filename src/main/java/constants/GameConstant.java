package constants;

public class GameConstant {
    public static final int PLAYER_NUMBER_LENGTH = 3;
    public static final int RESTART_NUMBER = 1;
    public static final int END_NUMBER = 2;
    public static final int RESTART_OR_END_NUMBER_LENGTH = 1;

    public static final String PATTERN = "^[0-9]*$"; //숫자만

    public static final String BALL_MESSAGE = "볼";
    public static final String STRIKE_MESSAGE = "스트라이크";
    public static final String NOTHING_MESSAGE = "낫싱";
    public static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해 주세요 : ";
    public static final String CLEAR_GAME_MESSAGE = String.format("&d개의 숫자를 모두 맞히셨습니다! 게임 종료", PLAYER_NUMBER_LENGTH);
    public static final String RESTART_OR_END_MESSAGE = String.format("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.", RESTART_NUMBER, END_NUMBER);

}
