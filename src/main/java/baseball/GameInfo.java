package baseball;

public class GameInfo {
    private static int ball;
    private static int strike;

    public GameInfo() {
        this.ball = 0;
        this.strike = 0;
    }

    public void addBall() {
        ball++;
    }

    public void addStrike() {
        strike++;
    }

    public String getResultString() {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }

        StringBuilder result = new StringBuilder();
        if (ball > 0) {
            result.append(Integer.toString(ball)).append("볼");
        }
        if (strike > 0) {
            if (result.length() > 0) {
                result.append(Integer.toString(strike)).append("스트라이크");
            }
        }
        return result.toString();
    }
}
