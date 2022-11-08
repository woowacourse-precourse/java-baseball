package baseball.model;

public class Ball implements Counter {

    private int score;

    @Override
    public void count() {
        score++;
    }

    @Override
    public String result() {
        if (score == 0) {
            return "";
        }
        return score + "볼 ";
    }

    public int getScore() {
        return score;
    }
}
