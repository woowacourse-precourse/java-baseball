package baseball;

import baseball.controller.RandomNumberGenerator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest extends NsTest {
    @DisplayName("랜덤 숫자 크기 테스트")
    @Test
    void randomNumberSizeTest() {
        // given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // when
        ArrayList<Integer> computer = randomNumberGenerator.RandomNumberGenerator();

        // then
        assertThat(computer.size()).isEqualTo(3);
    }

    @DisplayName("랜덤 숫자 범위 테스트")
    @Test
    void randomNumberRangeTest() {
        // given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        // when
        ArrayList<Integer> computer = randomNumberGenerator.RandomNumberGenerator();

        // then
        assertThat(computer.stream().allMatch(v -> v >= 1 && v <= 9)).isTrue();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
