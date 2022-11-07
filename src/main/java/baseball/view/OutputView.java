package baseball.view;

public class OutputView {

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printStrike(int strike) {
        System.out.printf("%d 스트라이크", strike);
    }

    public static void printBall(int ball) {
        System.out.printf("%d 볼", ball);
    }

    public static void printNothing() {
        System.out.println("낫싱");
    }

    public static void printFinish() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
    }
}
