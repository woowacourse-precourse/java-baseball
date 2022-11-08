package baseball;

import static baseball.BaseBallGameManager.allStrike;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class StrikeBallCheckerTest {

    @Test
    void matchAnswerTest() {
        // given
        List<Integer> answer = List.of(1, 2, 3);

        // when
        StrikeBallChecker strikeBallChecker = new StrikeBallChecker(answer);

        // then
        assertThat(strikeBallChecker.matchAnswer(answer)).isEqualTo(allStrike);
    }
}