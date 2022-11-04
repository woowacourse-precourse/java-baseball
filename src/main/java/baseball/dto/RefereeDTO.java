package baseball.dto;

import baseball.domain.BallStatusScore;
import baseball.domain.Referee;

import java.util.List;

public class RefereeDTO {
    private final List<Integer> ballStatusScores;
    
    public RefereeDTO(final Referee referee) {
        final BallStatusScore ball = referee.ball();
        final BallStatusScore strike = referee.strike();
        final int ballScore = ball.score();
        final int strikeScore = strike.score();
        
        ballStatusScores = List.of(ballScore, strikeScore);
    }
    
    public List<Integer> getBallStatusScores() {
        return ballStatusScores;
    }
}
