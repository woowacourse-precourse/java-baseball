package baseball.dto;

import baseball.domain.Referee;
import baseball.domain.score.Score;

import java.util.List;

public class RefereeDTO {
    private final List<Integer> pitchResults;
    
    public RefereeDTO(final Referee referee) {
        final Score ball = referee.ball();
        final Score strike = referee.strike();
        final int ballScore = ball.score();
        final int strikeScore = strike.score();
        
        pitchResults = List.of(ballScore, strikeScore);
    }
    
    public List<Integer> getPitchResults() {
        return pitchResults;
    }
}
