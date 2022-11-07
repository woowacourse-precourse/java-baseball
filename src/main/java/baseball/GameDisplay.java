package baseball;

public class GameDisplay {
    private static String GAME_START = "숫자 야구 게임을 시작합니다.";
    private static String QUESTIONS_ABOUT_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static String GAME_FINISH = "게임 종료";
    private static String INPUT_ERROR_ABOUT_RESTART = "재시작에 대한 입력이 잘못되었습니다.";
    private static String INPUT_ERROR_ABOUT_USER_NUMBER = "서로 다른 세자리 수를 입력해주세요.";
    private static String CORRECT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static String STRIKE = "스트라이크";
    private static String BALL = "볼";
    private static String NOTHING = "낫싱";
    private static String INPUT_YOUR_NUMBER = "숫자를 입력해주세요 : ";

    public static void gameStart() {
        System.out.println(GameDisplay.GAME_START);
    }

    public static void QUESTIONS_ABOUT_RESTART() {
        System.out.println(GameDisplay.QUESTIONS_ABOUT_RESTART);
    }

    public static String getInputErrorAboutRestart() {
        return GameDisplay.INPUT_ERROR_ABOUT_RESTART;
    }

    public static String getInputErrorAboutUserNumber() {
        return GameDisplay.INPUT_ERROR_ABOUT_USER_NUMBER;
    }

    public static void gameFinish() {
        System.out.println(GameDisplay.GAME_FINISH);
    }

    public static void answerCorrect() {
        System.out.println(GameDisplay.CORRECT);
    }

    public static void inputYourNumber() {
        System.out.println(GameDisplay.INPUT_YOUR_NUMBER);
    }

    public static void nothing() {
        System.out.println(GameDisplay.NOTHING);
    }

    public static void ball(int ball) {
        System.out.println(ball + GameDisplay.BALL);
    }

    public static void strike(int strike) {
        System.out.println(strike + GameDisplay.STRIKE);
    }

    public static void ballAndStrike(int ball, int strike) {
        System.out.println(ball + GameDisplay.BALL + " " + strike + GameDisplay.STRIKE);
    }
}
