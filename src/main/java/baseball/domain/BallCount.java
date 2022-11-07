package baseball.domain;

public class BallCount {

    private int Strikes;
    private int Balls;

    public BallCount(int strikes, int balls) {
        Strikes = strikes;
        Balls = balls;
    }

    public String ballCountResult() {
        if (Balls == 0 && Strikes == 0) {
            return "낫싱";
        }
        if (Strikes == 0) {
            return String.valueOf(Balls) + "볼";
        }
        if (Balls == 0) {
            return String.valueOf(Strikes) + "스트라이크";
        }
        return String.valueOf(Balls) + "볼 " + String.valueOf(Strikes) + "스트라이크";
    }
}
