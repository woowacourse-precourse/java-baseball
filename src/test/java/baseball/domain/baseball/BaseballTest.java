package baseball.domain.baseball;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BaseballTest {

    @Test
    void of_메서드_Baseball_생성() {
        int number = 1;

        int result = Baseball.of(number).getNumber();

        assertThat(result).isEqualTo(1);
    }

    @Test
    void of_메서드_숫자_범위_검증_실패() {
        int number = 10;

        assertThatThrownBy(() -> Baseball.of(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Baseball.OUT_OF_RANGE_MESSAGE);
    }

    @Test
    @RepeatedTest(100)
    void random_메서드_검증() {
        final int minBaseballNumber = 1;
        final int maxBaseballNumber = 9;

        int result = Baseball.random().getNumber();
        assertThat(result)
                .isGreaterThanOrEqualTo(minBaseballNumber)
                .isLessThanOrEqualTo(maxBaseballNumber);
    }

}