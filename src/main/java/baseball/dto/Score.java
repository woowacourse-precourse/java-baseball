package baseball.dto;

import baseball.vo.Answer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Score {
    public static final String INVALID_STRIKE_BALL_SCORE_MESSAGE = "제시한 스트라이크 또는 볼 점수가 잘못되었습니다.";
    public static final String STRIKE = "스트라이크";
    public static final String INVALID_ADDING_SCORE_REQUEST_MESSAGE_FORMAT = "스트라이크 또는 볼 점수는 %d점을 초과할 수 없습니다.";
    public static final String BALL = "볼";
    private final Map<String, Integer> score;

    public Score(Map<String, Integer> score) {
        this.score = score;
    }

    public static Score makeNewScore() {
        HashMap<String, Integer> score = new HashMap<>();
        score.put(STRIKE, 0);
        score.put(BALL, 0);
        return new Score(score);
    }

    public static Score makeNewScoreWith(Integer strike, Integer ball) {
        if (Answer.ANSWER_SIZE < strike || Answer.ANSWER_SIZE < ball || Answer.ANSWER_SIZE < strike + ball) {
            throw new IllegalArgumentException(INVALID_STRIKE_BALL_SCORE_MESSAGE);
        }

        HashMap<String, Integer> score = new HashMap<>();
        score.put(STRIKE, strike);
        score.put(BALL, ball);
        return new Score(score);
    }

    public void addStrike() {
        if (Answer.ANSWER_SIZE <= score.get(STRIKE)) {
            throw new IllegalArgumentException(String.format(INVALID_ADDING_SCORE_REQUEST_MESSAGE_FORMAT, Answer.ANSWER_SIZE));
        }
        score.put(STRIKE, score.get(STRIKE) + 1);
    }

    public void addBall() {
        if (Answer.ANSWER_SIZE <= score.get(BALL)) {
            throw new IllegalArgumentException(String.format(INVALID_ADDING_SCORE_REQUEST_MESSAGE_FORMAT, Answer.ANSWER_SIZE));
        }
        score.put(BALL, score.get(BALL) + 1);
    }

    public Integer getStrikeScore() {
        return score.get(STRIKE);
    }

    public Integer getBallScore() {
        return score.get(BALL);
    }

    public boolean isStrikeOut() {
        return score.get(STRIKE) == Answer.ANSWER_SIZE;
    }

    @Override
    public boolean equals(Object target) {
        if (this == target) {
            return true;
        }
        if (!(target instanceof Score)) {
            return false;
        }
        Score anotherScore = (Score) target;
        return score.equals(anotherScore.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }

    @Override
    public String toString() {
        return "Score{" +
                "score=" + score +
                '}';
    }
}
