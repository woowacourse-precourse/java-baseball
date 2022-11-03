package baseball.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RandomUtilsTest {

    @Test
    void 랜덤값_길이_확인() {
        List<Integer> result = RandomUtils.pickThreeRandomNumbers();
        assertThat(result.size()).isEqualTo(RandomUtils.RANDOM_NUMBERS_SIZE);
    }
}