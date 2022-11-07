package baseball;

public class MessagePrinter {
    private static final String INIT = "숫자 야구 게임을 시작합니다.";
    private static final String END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private static final String ASK_INPUT = "숫자를 입력해주세요 : ";
    private static final String ASK_REPLAY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";


    public void printInit() {
        System.out.println(INIT);
    }

    public void printFinish() {
        System.out.println(END);
    }

    public void askInput() {
        System.out.print(ASK_INPUT);
    }

    public void askReplay() {
        System.out.println(ASK_REPLAY);
    }

    public void printResult(int ballCount, int strikeCount) {
        String message = getResultMessage(ballCount, strikeCount);
        System.out.println(message);
    }

    public String getResultMessage(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            return NOTHING;
        }
        if (ballCount == 0) {
            return strikeCount + STRIKE;
        }

        if (strikeCount == 0) {
            return ballCount + BALL;
        }
        return ballCount + BALL + " " + strikeCount + STRIKE;
    }
}
