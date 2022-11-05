package baseball.engine;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class BaseballEngineTest {

    private final BaseballEngine engine = new BaseballEngine();

    @Test
    void generateAnswer_함수로_3개의_값을_반환() {
        List<Integer> answer = engine.generateAnswer();

        assertThat(answer).hasSize(3);
    }

    @Test
    void generateAnswer_함수로_1과_9사이의_값을_반환() {
        List<Integer> answer = engine.generateAnswer();

        for (int i : answer) {
            assertThat(i)
                    .isPositive()
                    .isLessThan(10);
        }

    }

    @Test
    void generateAnswer_함수로_중복되지_않는_값을_반환() {
        List<Integer> answer = engine.generateAnswer();

        for (int i : answer) {
            long count = answer.stream()
                    .filter(j -> j == i)
                    .count();

            assertThat(count).isEqualTo(1);
        }

    }
}