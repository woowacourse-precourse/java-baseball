package baseball.opponent;

import baseball.core.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("generate 테스트")
    void test() {
        //given
        int expectedMinNum = 1;
        int expectedMaxNum = 9;
        int expectedSize = 3;

        //when
        List<Integer> res = RandomNumberGenerator.generate();

        //then
        assertThat(res.size()).isEqualTo(expectedSize);
        for (Integer num : res) {
            assertThat(num).isGreaterThanOrEqualTo(expectedMinNum);
            assertThat(num).isLessThanOrEqualTo(expectedMaxNum);
        }
    }

}