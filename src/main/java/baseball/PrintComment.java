package baseball;

public class PrintComment {
    private static final String START = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_COMMENT = "숫자를 입력해주세요 : ";
    private static final String CORRECT_COMMENT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final int ZERO = 0;

    public static void printStartComment() {
        System.out.println(START);
    }

    public static void printInputComment() {
        System.out.print(INPUT_COMMENT);
    }

    public static void printUserInput(String numbers) {
        System.out.println(numbers);
    }

    public static void printGameState(GameState gameState) {
        if (gameState.getStrike()==ZERO && gameState.getBall()==ZERO) {
            System.out.println(NOTHING);
            return;
        }
        if (gameState.getBall()==ZERO) {
            System.out.println(gameState.getStrike()+STRIKE);
            return;
        }
        if (gameState.getStrike()==ZERO) {
            System.out.println(gameState.getBall()+BALL);
            return;
        }
        System.out.println(gameState.getBall()+BALL+" "+gameState.getStrike()+STRIKE);
    }

    public static void printCorrectComment() {
        System.out.println(CORRECT_COMMENT);
    }
}