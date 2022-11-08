package baseball.dto;

import baseball.domain.BallStatus;
import baseball.domain.Referee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ScoresDTOTest {
    @Test
    @DisplayName("불변 데이터를 반환하는지 확인")
    void is_immutable_data() {
        Referee referee = new Referee();
        referee.decide(List.of(BallStatus.STRIKE, BallStatus.BALL, BallStatus.STRIKE));
        final List<Integer> scores = new ScoresDTO(referee).getScores();
        
        assertThatThrownBy(() -> scores.add(2))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}