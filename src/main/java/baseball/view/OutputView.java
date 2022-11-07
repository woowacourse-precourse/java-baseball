package baseball.view;


public class OutputView {
    public int strike = 0;
    public int ball = 0;

    public OutputView() {
        HintOutput(strike, ball);
    }

    public static void HintOutput(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        if (strike == 3) {
            System.out.println("3스트라이크");
        }
        if (strike == 0) {
            System.out.println(ball+"볼");
        }
        if (ball == 0) {
            System.out.println(strike+"스트라이크");
        }
        System.out.println(ball+"볼 "+strike+"스트라이크");
    }

}
