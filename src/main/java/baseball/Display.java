package baseball;

public class Display {
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

    public static void start() {
        System.out.println(Display.GAME_START);
    }

    public static void QUESTIONS_ABOUT_RESTART() {
        System.out.println(Display.QUESTIONS_ABOUT_RESTART);
    }

    public static String getInputErrorAboutRestart() {
        return Display.INPUT_ERROR_ABOUT_RESTART;
    }

    public static String getInputErrorAboutUserNumber() {
        return Display.INPUT_ERROR_ABOUT_USER_NUMBER;
    }

    public static void finish() {
        System.out.println(Display.GAME_FINISH);
    }

    public static void answerCorrect() {
        System.out.println(Display.CORRECT);
    }

    public static void inputYourNumber() {
        System.out.println(Display.INPUT_YOUR_NUMBER);
    }

    public static void nothing() {
        System.out.println(Display.NOTHING);
    }


    public static void printHint(int ball, int strike) {

        String hintMessage = "";

        if (ball == 0 && strike != 0) {
            hintMessage = strike + Display.STRIKE;
        } else if (strike == 0 && ball != 0) {
            hintMessage = ball + Display.BALL;
        } else if (ball != 0 && strike != 0) {
            hintMessage = ball + Display.BALL + " " + strike + Display.STRIKE;
        } else {
            hintMessage = Display.NOTHING;
        }

        System.out.println(hintMessage);

    }
}
