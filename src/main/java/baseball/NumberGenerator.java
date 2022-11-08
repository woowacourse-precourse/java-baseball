package baseball;

public class NumberGenerator {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    static final int NUMBER_COUNT = 3;
    private static final int NEW_GAME = 1;
    private static final int QUIT_GAME = 2;

    private static final String GET_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String SUCCESS_MESSAGE = NumberGenerator.NUMBER_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NEW_GAME_CHECK_MESSAGE = "게임을 새로 시작하려면 " + NumberGenerator.NEW_GAME + ", 종료하려면 " + NumberGenerator.QUIT_GAME + "를 입력하세요.";

    
}
