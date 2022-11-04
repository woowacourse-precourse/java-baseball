package baseball.dto;

import baseball.domain.Referee;
import baseball.domain.score.Score;

import java.util.List;

public class ScoresDTO {
    private final List<Integer> scores;
    
    public ScoresDTO(final Referee referee) {
        final Score ball = referee.ball();
        final Score strike = referee.strike();
        final int ballScore = ball.score();
        final int strikeScore = strike.score();
        
        scores = List.of(ballScore, strikeScore);
    }
    
    public List<Integer> getScores() {
        return scores;
    }
}
