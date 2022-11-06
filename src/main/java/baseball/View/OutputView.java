package baseball.View;

public class OutputView {

    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크";
    private static final int ZERO = 0;
    private static final String NOTTHING = "낫싱";
    private final String INPUTNUM = "숫자를 입력해주세요 : ";
    private static final String STARTMESSAGE = "숫자 야구 게임을 시작합니다.";

    public void startGameMessage() {
        System.out.println(STARTMESSAGE);
    }

    public void inputNumMessage() {
        System.out.print(INPUTNUM);
    }

    public void printResultState(int ball, int strike) {
        StringBuilder message = new StringBuilder();
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
}
