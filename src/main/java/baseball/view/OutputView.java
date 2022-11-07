package baseball.view;

public class OutputView {

    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printStrike(int strike) {
        System.out.printf("%d 스트라이크", strike);
    }
}
