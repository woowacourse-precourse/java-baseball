package game;

public class Hint {
    private int ball = 0;
    private int strike = 0;

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void incrementBall() {
        ball++;
    }

    public void incrementStrike() {
        strike++;
    }

    public void clearHint() {
        ball = 0;
        strike = 0;
    }

    public void print() {
        String hintMessage = "";

        if (ball != 0) {
            hintMessage += ball + "볼 ";
        }
        if (strike != 0) {
            hintMessage += strike + "스트라이크";
        }
        if (ball == 0 && strike == 0) {
            hintMessage += "낫싱";
        }

        System.out.println(hintMessage);
    }
}
