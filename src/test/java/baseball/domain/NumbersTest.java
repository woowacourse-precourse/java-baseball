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

//    @Test
//    void countStrike_올바른_반환값() {
//        Numbers baseball1 = new Numbers(Arrays.asList(1,2,3));
//        Numbers baseball2 = new Numbers(Arrays.asList(1,5,3));
//        assertThat(baseball1.countStrike(baseball2)).isEqualTo(2);
//    }
//
//    @Test
//    void countBall_올바른_반환값() {
//        Numbers baseball1 = new Numbers(Arrays.asList(1,2,3));
//        Numbers baseball2 = new Numbers(Arrays.asList(3,5,2));
//        assertThat(baseball1.countBall(baseball2)).isEqualTo(2);
//    }
}