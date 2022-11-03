package baseball.input;

import baseball.count.BallAndStrikeCounter;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class BallAndStrikeCounterTest {

    private static final String BALL_KEY = "ball";
    private static final String STRIKE_KEY = "strike";
    private final BallAndStrikeCounter ballAndStrikeCounter = new BallAndStrikeCounter();
    private final List<Integer> answer = List.of(1, 2, 3);

    @Test
    void ball이_3개인_경우() {
        String inputValue = "312";
        Map<String, Integer> ballAndStrikeCount = ballAndStrikeCounter.checkBallAndStrikeCount(answer, inputValue);
        assertThat(ballAndStrikeCount.get(BALL_KEY)).isEqualTo(3);
        assertThat(ballAndStrikeCount.get(STRIKE_KEY)).isEqualTo(0);
    }

    @Test
    void strike가_3개인_경우() {
        String inputValue = "123";
        Map<String, Integer> ballAndStrikeCount = ballAndStrikeCounter.checkBallAndStrikeCount(answer, inputValue);
        assertThat(ballAndStrikeCount.get(BALL_KEY)).isEqualTo(0);
        assertThat(ballAndStrikeCount.get(STRIKE_KEY)).isEqualTo(3);
    }

    @Nested
    class 섞여있는_경우 {
        @Test
        void case1() {
            String inputValue = "124";
            Map<String, Integer> ballAndStrikeCount = ballAndStrikeCounter.checkBallAndStrikeCount(answer, inputValue);
            assertThat(ballAndStrikeCount.get(BALL_KEY)).isEqualTo(0);
            assertThat(ballAndStrikeCount.get(STRIKE_KEY)).isEqualTo(2);
        }

        @Test
        void case2() {
            String inputValue = "132";
            Map<String, Integer> ballAndStrikeCount = ballAndStrikeCounter.checkBallAndStrikeCount(answer, inputValue);
            assertThat(ballAndStrikeCount.get(BALL_KEY)).isEqualTo(2);
            assertThat(ballAndStrikeCount.get(STRIKE_KEY)).isEqualTo(1);
        }

        @Test
        void case3() {
            String inputValue = "189";
            Map<String, Integer> ballAndStrikeCount = ballAndStrikeCounter.checkBallAndStrikeCount(answer, inputValue);
            assertThat(ballAndStrikeCount.get(BALL_KEY)).isEqualTo(0);
            assertThat(ballAndStrikeCount.get(STRIKE_KEY)).isEqualTo(1);
        }

        @Test
        void case4() {
            String inputValue = "345";
            Map<String, Integer> ballAndStrikeCount = ballAndStrikeCounter.checkBallAndStrikeCount(answer, inputValue);
            assertThat(ballAndStrikeCount.get(BALL_KEY)).isEqualTo(1);
            assertThat(ballAndStrikeCount.get(STRIKE_KEY)).isEqualTo(0);
        }
    }


    @Test
    void 아무것도_매칭되는게_없는_경우() {
        String inputValue = "789";
        Map<String, Integer> ballAndStrikeCount = ballAndStrikeCounter.checkBallAndStrikeCount(answer, inputValue);
        assertThat(ballAndStrikeCount.get(BALL_KEY)).isEqualTo(0);
        assertThat(ballAndStrikeCount.get(STRIKE_KEY)).isEqualTo(0);
    }
}