package baseball.domain;

import java.util.List;

public class ScoreManager {
    private Score userScore;

    public void makeUserScore(BaseballNumber baseballNum1, BaseballNumber baseballNum2) {
        userScore = ScoreCalculator.calculateUserFinalScore(baseballNum1, baseballNum2);
    }

    public List<Integer> getUserScore() {
        return userScore.getScore();
    }
}
