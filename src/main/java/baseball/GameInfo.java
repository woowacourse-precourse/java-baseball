package baseball;

public class GameInfo {
    private int ball;
    private int strike;

    public GameInfo() {
        ball = 0;
        strike = 0;
    }

    public void increaseBall() {
        ball++;
    }

    public void increaseStrike() {
        strike++;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public String getResult() {
        String result = "";
        if (getBall() == 0 && getStrike() == 0)
            result += "낫싱";
        else {
            if (getBall() != 0)
                result += getBall() + "볼 ";
            if (getStrike() != 0)
                result += getStrike() + "스트라이크";
        }
        return result;
    }
}
