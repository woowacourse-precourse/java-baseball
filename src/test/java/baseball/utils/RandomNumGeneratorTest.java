package baseball.utils;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RandomNumGeneratorTest {
    @Test
    void 랜덤값으로_3자리수를_구성하는지_체크() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThat(RandomNumGenerator.makeDistinctRandomNumWithSize(3))
                            .isEqualTo(135);
                    assertThat(RandomNumGenerator.makeDistinctRandomNumWithSize(3))
                            .isEqualTo(479);
                },
                1, 3, 5, 4, 7, 9
        );
    }
}