package baseball.count;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class BallAndStrikeCounterTest {

    private static final String BALL_KEY = "ball";
    private static final String STRIKE_KEY = "strike";

    private final BallAndStrikeCounter ballAndStrikeCounter = new BallAndStrikeCounter();

    @Test
    void 전부_ball인_경우() {
        List<Integer> answer = List.of(1, 2, 3);
        String inputValue = "312";

        Map<String, Integer> ballAndStrikeCount = ballAndStrikeCounter.checkBallAndStrikeCount(answer, inputValue);

        assertThat(ballAndStrikeCount.get(BALL_KEY)).isEqualTo(3);
        assertThat(ballAndStrikeCount.get(STRIKE_KEY)).isEqualTo(0);
    }

    @Test
    void 전부_strike인_경우() {
        List<Integer> answer = List.of(1, 2, 3);
        String inputValue = "123";

        Map<String, Integer> ballAndStrikeCount = ballAndStrikeCounter.checkBallAndStrikeCount(answer, inputValue);

        assertThat(ballAndStrikeCount.get(BALL_KEY)).isEqualTo(0);
        assertThat(ballAndStrikeCount.get(STRIKE_KEY)).isEqualTo(3);
    }

    @Test
    void 아무것도_못_맞춘_경우() {
        List<Integer> answer = List.of(1, 2, 3);
        String inputValue = "456";

        Map<String, Integer> ballAndStrikeCount = ballAndStrikeCounter.checkBallAndStrikeCount(answer, inputValue);

        assertThat(ballAndStrikeCount.get(BALL_KEY)).isEqualTo(0);
        assertThat(ballAndStrikeCount.get(STRIKE_KEY)).isEqualTo(0);
    }
}