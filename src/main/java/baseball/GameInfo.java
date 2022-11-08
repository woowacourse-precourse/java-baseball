package baseball;

public class GameInfo {
    private int ball;
    private int strike;

    public GameInfo() {
        ball = 0;
        strike = 0;
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
            result.append(ball).append("볼");
        }
        if (strike > 0) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(strike).append("스트라이크");

        }
        return result.toString();
    }

    public boolean isAnswer() {
        if (strike == 3) {
            return true;
        }
        return false;
    }
}
