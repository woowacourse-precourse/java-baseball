package baseball.model;

public class Strike implements Counter {

    private static final int MAXIMUM_STRIKE = 3;
    private int score;

    public boolean isThreeStrike() {
        return score == MAXIMUM_STRIKE;
    }

    @Override
    public void count() {
        score++;
    }

    @Override
    public String result() {
        if (score == 0) {
            return "";
        }
        return score + "스트라이크";
    }

    public int getScore() {
        return score;
    }
}
