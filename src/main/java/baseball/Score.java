package baseball;

public class Score {
    private int strike = 0;
    private int ball = 0;

    public void plusStrike() {
        strike++;
    }

    public void plusBall() {
        ball++;
    }

    public String getScore() {
        String result = "";

        if (ball == 0 && strike == 0) return "낫싱";
        if (ball > 0) {
            result = result + ball + "볼 ";
        }
        if (strike > 0) {
            result = result + strike + "스트라이크 ";
        }

        return result.substring(0, result.length() - 1);
    }

}
