package baseball;

public class ShowMessage {
    private static final int NEW_GAME = 1;
    private static final int QUIT_GAME = 2;
    private static final int GAME_SET_COUNT = 3;

    private static final String BALL_WORD = "볼";
    private static final String STRIKE_WORD = "스트라이크";
    private static final String NOT_MATCH_WORD = "낫싱";

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_SET_MESSAGE = GAME_SET_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NEW_GAME_CHECK_MESSAGE = "게임을 새로 시작하려면" + NEW_GAME + ", " + "종료하려면 " + QUIT_GAME
            + "를 입력하세요.";
}
