package baseball.userInterface;

public class View {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ASK_PLAY_AGAIN_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작하겠습니다.";
    private static final String END_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void ViewInputNumber() {
        System.out.println(INPUT_NUMBER_MESSAGE);
    }

    public static void viewAskPlayAgainMessage() {
        System.out.println(ASK_PLAY_AGAIN_MESSAGE);
    }

    public static void viewStartGameMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public static void viewEndGameMessage() {
        System.out.println(END_GAME_MESSAGE);
    }
}
