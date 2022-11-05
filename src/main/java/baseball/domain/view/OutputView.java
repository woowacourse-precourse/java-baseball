package baseball.domain.view;

public class OutputView {
    public static final String startGame = "숫자 야구 게임을 시작합니다.";

    public static void startView() {
        System.out.println(startGame);
    }

    public static void printResult(int strike, int ball) {
        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike == 0 && ball != 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike != 0) {
            System.out.println(ball + "볼");
        }
    }
}
