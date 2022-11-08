package baseball.view;

public class OutputView {
    public static final String INIT_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String NOTTING_MESSAGE = "낫싱";
    public static final String STRIKE_MESSAGE = "스트라이크";
    public static final String BALL_MESSAGE = "볼";
    public static final String WIN_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printInitGameMessage() {
        System.out.println(INIT_MESSAGE);
    }

    public String printNothing() {
        System.out.println(NOTTING_MESSAGE);
        return NOTTING_MESSAGE;
    }

    public String printResult(int strike, int ball) {
        String result = "";
        if (ball > 0) {
            result += ball + BALL_MESSAGE + " ";
        }
        if (strike > 0) {
            result += strike + STRIKE_MESSAGE;
        }
        System.out.println(result);

        return result;
    }

    public void printWinGame(int strike) {
        System.out.println(strike + STRIKE_MESSAGE);
        System.out.println(WIN_GAME_MESSAGE);
    }
}
