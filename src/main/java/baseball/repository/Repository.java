package baseball.repository;

public class Repository {
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Repository(int score) {
        this.score = score;
    }

}
