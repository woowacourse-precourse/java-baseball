package baseball.dto;

import baseball.domain.Referee;

import java.util.Collections;
import java.util.List;

public class ScoresDTO {
    private final List<Integer> scores;
    
    public ScoresDTO(final Referee referee) {
        scores = referee.scores();
    }
    
    public List<Integer> getScores() {
        return Collections.unmodifiableList(scores);
    }
}
