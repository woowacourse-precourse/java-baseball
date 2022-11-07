package baseball.view;

public class BaseBallView {
    private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크 ";
    private static final String NOTHING = "낫싱";
    private static final String GET_RIGHT_ANSWER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String INPUT_NEW_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printGameStart() {
        System.out.println(GAME_START);
    }

    public static void printInputNumber() {
        System.out.print(INPUT_NUMBER);
    }

    public static void printBall(int count) {
        System.out.print(count + BALL);
    }

    public static void printStrike(int count) {
        System.out.print(count + STRIKE);
    }

    public static void printNothing() {
        System.out.print(NOTHING);
    }

    public static void printGiveCorrectAnswer() {
        System.out.println(GET_RIGHT_ANSWER);
    }

    public static void printInputNewGame() {
        System.out.println(INPUT_NEW_GAME);
    }
}
