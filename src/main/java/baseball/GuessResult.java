package baseball;

public class GuessResult {
    private int balls;
    private int strikes;

    private GuessResult() {}

    public static GuessResult byBallsAndStrikes(int balls, int strikes) {
        GuessResult res = new GuessResult();
        res.balls = balls;
        res.strikes = strikes;

        return res;
    }

    public boolean isCorrect() {
        return strikes == GameNumbers.LENGTH;
    }

    public String toSpecString() {
        String s = "";

        if (balls > 0) {
            s += String.format("%s볼 ", balls);
        }
        if (strikes > 0) {
            s += String.format("%s스트라이크", strikes);
        }
        if (balls == 0 && strikes == 0) {
            s = "낫싱";
        }

        return s;
    }

    @Override
    public String toString() {
        return "GuessResult{" +
            "balls=" + balls +
            ", strikes=" + strikes +
            '}';
    }
}