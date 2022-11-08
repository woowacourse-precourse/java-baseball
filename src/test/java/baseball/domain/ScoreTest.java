package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    @Test
    void increaseStrikeTest() {
        Score score = new Score(0, 0);
        int result = 1;
        score.increaseStrike();
        Assertions.assertThat(score.getStrike()).isEqualTo(result);
    }

    @Test
    void increaseBallTest() {
        Score score = new Score(0, 0);
        int result = 1;
        score.increaseBall();
        Assertions.assertThat(score.getBall()).isEqualTo(result);
    }
}