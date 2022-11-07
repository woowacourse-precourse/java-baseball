package baseball.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class RandomUtilsTest {

    @Test
    void 랜덤값_길이_확인() {
        List<Integer> result = RandomUtils.pickThreeRandomNumbers();
        assertThat(result.size()).isEqualTo(RandomUtils.RANDOM_NUMBERS_SIZE);
    }

    @Test
    void 랜덤값_check() {
        List<Integer> result = RandomUtils.pickThreeRandomNumbers();
        Set<Integer> duplicateResult = new HashSet<>(result);
        assertThat(result.size()).isEqualTo(duplicateResult.size());
    }
}