package baseball.print;

public class OutputStatement {
    public static void informStartNumberBaseballGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void requestNumberInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private static void printNotSing() {
        System.out.println("낫싱");
    }

    public static void printHint(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            printNotSing();
        } else if (ball == 0) {
            printStrikeCntNumber(strike);
        } else if (strike == 0) {
            printBallCntNumber(ball);
        } else {
            printBallAndStrikeCntNumber(ball, strike);
        }
    }

    public static void informResultAnswerAndFinish() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void askGameRestartOrFinish() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private static void printBallCntNumber(int ball) {
        System.out.println(ball + "볼");
    }

    private static void printStrikeCntNumber(int strike) {
        System.out.println(strike + "스트라이크");
    }

    private static void printBallAndStrikeCntNumber(int ball, int strike) {
        System.out.println(ball + "볼" + " " + strike + "스트라이크");
    }


}
