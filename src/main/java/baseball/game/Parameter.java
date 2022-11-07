package baseball.game;

public class Parameter {
    private static int strike;
    private static int ball;

    public  static void initParam() {
        strike = 0;
        ball = 0;
    }

    public static int getStrike() {
        return strike;
    }

    public static int getBall() {
        return ball;
    }

    public static void addStrike() {
        strike++;
    }

    public static void addBall() {
        ball++;
    }
}
