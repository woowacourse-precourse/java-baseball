package baseball;

public class ShowMessage {
    private static final int NEW_GAME = 1;
    private static final int QUIT_GAME = 2;
    private static final int ANSWER_COUNT = 3;

    private static final String BALL_WORD = "볼";
    private static final String STRIKE_WORD = "스트라이크";
    private static final String NOT_MATCH_WORD = "낫싱";

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String END_GAME_MESSAGE = ANSWER_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NEW_GAME_CHECK_MESSAGE = "게임을 새로 시작하려면" + NEW_GAME + ", " + "종료하려면 " + QUIT_GAME
            + "를 입력하세요.";

    public static void showNotMatchWord() {
        System.out.println(NOT_MATCH_WORD);
    }

    // 게임 시작
    public static void showGameStart() {
        System.out.print(GAME_START_MESSAGE);
    }

    // 숫자 입력
    public static void showInputNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    // 게임 종료
    public static void showEndGame() {
        System.out.println(END_GAME_MESSAGE);
    }

    // 게임 재시작 여부
    public static void showNewGameCheck() {
        System.out.println(NEW_GAME_CHECK_MESSAGE);
    }

    // 숫자의 개수
    public int getAnswerCount() {
        return ANSWER_COUNT;
    }

    public static void showEndGameNewGameCheck() {
        showEndGame();
        showNewGameCheck();
    }

    public void showGameScore(int ballCount, int strikeCount) {
        if(strikeCount == 0){
            System.out.println(ballCount+BALL_WORD);
        } else if (ballCount == 0) {
            System.out.println(strikeCount+STRIKE_WORD);
        }else {
            System.out.println(ballCount + BALL_WORD + " " + strikeCount + STRIKE_WORD);
        }
    }

}
