package baseball.view;

public class OutputView {

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printResult(int strike, int ball) {
        String result = String.join(" ", printBall(ball), printStrike(strike));
        System.out.println(result.trim());
    }

    private static String printStrike(int strike) {
        if (strike == 0) {
            return "";
        }
        return String.format("%d스트라이크", strike);
    }

    private static String printBall(int ball) {
        if (ball == 0) {
            return "";
        }
        return String.format("%d볼", ball);
    }

    public static void printNothing() {
        System.out.println("낫싱");
    }

    public static void printFinish() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
