package baseball.game;

public class GameGuide {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ENDGAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    private static final String ENDORRE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void startMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void inputMessage() {
        System.out.print(INPUT_MESSAGE);
    }

    public static void reOrEndGameMessage() {
        System.out.println(ENDGAME_MESSAGE + ENDORRE_MESSAGE);
    }
}
