package baseball.domain;

import java.util.List;

public enum Result {
    NON(0), BALL(0), STRIKE(0);

    private int score;

    Result(int score) {
        this.score = score;
    }

    public void add() {
        this.score++;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public static Result judge(Integer userIndex, Integer computerIndex) {
        if (computerIndex == userIndex) {
            return STRIKE;
        }
        if (computerIndex != -1 && computerIndex != userIndex) {
            return BALL;
        }
        return NON;
    }

    public static void initialize() {
        List.of(values()).forEach(result -> result.setScore(0));
    }

    public static void update(Result result) {
        result.add();
    }

    public static Integer getStrike() {
        return STRIKE.getScore();
    }

    public static Integer getBall() {
        return BALL.getScore();
    }
}
