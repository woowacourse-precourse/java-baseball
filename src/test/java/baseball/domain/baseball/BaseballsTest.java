package baseball.domain.baseball;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballsTest {

    @Test
    @RepeatedTest(100)
    void random_메서드_검증() {

        int result =
                (int) Baseballs.random()
                        .getBaseballs()
                        .stream()
                        .filter(number -> Baseball.MIN_BASEBALL_NUMBER <= number.getNumber() &&
                                number.getNumber() <= Baseball.MAX_BASEBALL_NUMBER)
                        .count();

        assertThat(result).isEqualTo(3);
    }
}