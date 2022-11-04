package baseball.count;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static baseball.config.GameConfiguration.DIGITS_FOR_THIS_GAME;
import static org.assertj.core.api.Assertions.assertThat;

class BallAndStrikeCounterTest {

    private static final String BALL_KEY = "ball";
    private static final String STRIKE_KEY = "strike";

    private final BallAndStrikeCounter ballAndStrikeCounter = new BallAndStrikeCounter();
    private final List<Integer> answer = new ArrayList<>();
    private final CaseGenerator caseGenerator = new CaseGenerator();

    @BeforeEach
    void init() {
        IntStream.range(1, DIGITS_FOR_THIS_GAME + 1)
                .forEach(answer::add);
    }

    @Test
    void 전부_ball인_경우() {
        String inputValue = caseGenerator.createBallCase(answer);
        Map<String, Integer> ballAndStrikeCount = ballAndStrikeCounter.checkBallAndStrikeCount(answer, inputValue);

        assertThat(ballAndStrikeCount.get(BALL_KEY)).isEqualTo(DIGITS_FOR_THIS_GAME);
        assertThat(ballAndStrikeCount.get(STRIKE_KEY)).isEqualTo(0);
    }

    @Test
    void 전부_strike인_경우() {
        String inputValue = answer.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        Map<String, Integer> ballAndStrikeCount = ballAndStrikeCounter.checkBallAndStrikeCount(answer, inputValue);

        assertThat(ballAndStrikeCount.get(BALL_KEY)).isEqualTo(0);
        assertThat(ballAndStrikeCount.get(STRIKE_KEY)).isEqualTo(DIGITS_FOR_THIS_GAME);
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