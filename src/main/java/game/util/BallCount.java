package game.util;

public class BallCount {
    private int ball;
    private int strike;

    public BallCount() {
        ball = 0;
        strike = 0;
    }

    public void addBall() {
        ball += 1;
    }

    public void addStrike() {
        strike += 1;
    }

    public void minusBall() {
        ball -= 1;
    }

    public void printCount() {
        String ballAndStrike = "";
        if (ball != 0) {
            ballAndStrike += ball + "볼 ";
        }
        if (strike != 0) {
            ballAndStrike += strike + "스트라이크";
        }
        if (ball == 0 && strike == 0) {
            ballAndStrike += "낫싱";
        }
        System.out.println(ballAndStrike);
    }

    public boolean strikeOut() {
        return strike == 3;
    }
}
