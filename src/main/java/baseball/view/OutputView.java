package baseball.view;

public class OutputView {
    private static final String INIT_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String NOTTING = "낫싱";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";

    public static void printInitGameMessage() {
        System.out.println(INIT_MESSAGE);
    }

    public void printNothing() {
        System.out.println(NOTTING);
    }

    public void printResult(int strike, int ball) {
        String result = "";
        if (ball > 0) {
            result += ball + BALL + " ";
        }
        if (strike > 0 ) {
            result += strike + STRIKE;
        }
        System.out.println(result);
    }
}
