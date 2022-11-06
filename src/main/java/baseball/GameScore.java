package baseball;

public class GameScore {
    Integer strike;
    Integer ball;

    public GameScore(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void printResult() {
        if (strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }

        if (strike > 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        }

        if (strike == 0 && ball > 0) {
            System.out.println(ball + "볼");
        }

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
    }
}
