package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import baseball.domain.number.BaseballNumbers;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class BaseballNumbersTest {

    @Test
    void 중복된_숫자_exception_반환() {
        assertThatThrownBy(() -> new BaseballNumbers(Arrays.asList(1,1,3))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 범위_벗어난_숫자_exception_반환() {
        assertThatThrownBy(() -> new BaseballNumbers(Arrays.asList(1,3,10))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수_포함_exception_반환() {
        assertThatThrownBy(() -> new BaseballNumbers(Arrays.asList(-1,3,8))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void countStrike_올바른_반환값() {
        BaseballNumbers baseballNumbers = new BaseballNumbers(Arrays.asList(1,2,3));
        BaseballNumbers other = new BaseballNumbers(Arrays.asList(2,1,3));
        assertThat(baseballNumbers.countStrike(other)).isEqualTo(1);
    }

    @Test
    void countBall_올바른_반환값() {
        BaseballNumbers baseballNumbers = new BaseballNumbers(Arrays.asList(1,2,3));
        BaseballNumbers other = new BaseballNumbers(Arrays.asList(1,5,2));
        assertThat(baseballNumbers.countBall(other)).isEqualTo(1);
    }
}