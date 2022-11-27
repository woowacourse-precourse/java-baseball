package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @Test
    void 중복된_숫자_exception_반환() {
        assertThatThrownBy(() -> new Numbers(Arrays.asList(1,1,3))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 범위_벗어난_숫자_exception_반환() {
        assertThatThrownBy(() -> new Numbers(Arrays.asList(1,3,10))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수_포함_exception_반환() {
        assertThatThrownBy(() -> new Numbers(Arrays.asList(-1,3,8))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void countSameNumber_올바른_반환값() {
        Numbers number = new Numbers(Arrays.asList(1,2,3));
        Numbers other = new Numbers(Arrays.asList(2,1,3));
        assertThat(number.countSameNumber(other)).isEqualTo(3);
    }

    @Test
    void countCorrectNumber_올바른_반환값() {
        Numbers number = new Numbers(Arrays.asList(1,2,3));
        Numbers other = new Numbers(Arrays.asList(1,5,2));
        assertThat(number.countCorrectNumber(other)).isEqualTo(1);
    }
}