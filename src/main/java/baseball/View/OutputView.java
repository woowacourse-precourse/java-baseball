package baseball.View;

public class OutputView {

    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크";
    private static final int ZERO = 0;
    private static final String NOTTHING = "낫싱";
    public static final String THREESTRIKE = "3스트라이크";
    private final String INPUTNUM = "숫자를 입력해주세요 : ";
    private static final String STARTMESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String VICTORY = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String STARTOREND = "게임을 새로 시작하려면 1, 종료하면 2를 입력하세요.";

    public void startGameMessage() {
        System.out.println(STARTMESSAGE);
    }

    public void inputNumMessage() {
        System.out.print(INPUTNUM);
    }

    public void printResultState(int ball, int strike) {
        StringBuilder message = new StringBuilder();
        if(strike == 3) {
            printStrike();
            return;
        }
        if (ball > ZERO) {
            message.append(ball).append(BALL);
        }
        if (strike > ZERO) {
            message.append(strike).append(STRIKE);
        }
        if (ball == ZERO && strike == ZERO) {
            message.append(NOTTHING);
        }
        System.out.println(message);
    }

    public void printStrike() {
        System.out.println(THREESTRIKE);
        System.out.println(VICTORY);
    }
}
