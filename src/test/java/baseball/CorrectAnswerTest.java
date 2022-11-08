package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CorrectAnswerTest {

    @Test
    public void batPitchedBall() {
        assertRandomNumberInRangeTest(() -> {
            CorrectAnswer correctAnswer1 = new CorrectAnswer();
            assertThat(correctAnswer1.batPitchedBall(3, 0)).isEqualTo(PitchResult.BALL);
            assertThat(correctAnswer1.batPitchedBall(1, 0)).isEqualTo(PitchResult.STRIKE);
            assertThat(correctAnswer1.batPitchedBall(2, 0)).isEqualTo(PitchResult.NONE);
        }, 1, 3, 5);
    }

}