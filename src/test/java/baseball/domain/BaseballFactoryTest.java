package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class BaseballFactoryTest {

    @Test
    void 서로_다른_1부터_9사이의_임의의_수_3개를_생성하여_반환한다() {
        List<Baseball> result = BaseballFactory.generate();

        long countOfDistinctBaseball = result.stream()
                .distinct()
                .count();

        assertThat(countOfDistinctBaseball).isEqualTo(3L);
    }

}
