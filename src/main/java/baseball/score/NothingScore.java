package baseball.score;

public class NothingScore implements Score {
    @Override
    public int getStrike() {
        return 0;
    }

    @Override
    public int getBall() {
        return 0;
    }

    @Override
    public String toString() {
        return "낫싱";
    }
}
