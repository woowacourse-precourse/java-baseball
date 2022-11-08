package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomGeneratorTest {

    private final int MIN = 1;
    private final int MAX = 9;
    private final int NUMBERS_SIZE = 3;

    @DisplayName("1에서 9까지 서로 다른 임의의 수 3개를 선택한다.")
    @RepeatedTest(10)
    void randomNumber() {
        RandomGenerator randomGenerator = new RandomGenerator();
        List<Integer> numbers = randomGenerator.pickNumbers();
        long size = numbers.stream().distinct().count();
        long outBoundCount = numbers.stream()
                .filter(number -> (number < MIN) || (number > MAX))
                .count();

        Assertions.assertAll(
                () -> assertThat(size).isEqualTo(NUMBERS_SIZE),
                () -> assertThat(outBoundCount).isEqualTo(0)
        );
    }
}
