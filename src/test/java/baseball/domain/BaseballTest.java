package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class BaseballTest {

    @Test
    void 중복된_숫자_exception_반환() {
        assertThatThrownBy(() -> new Baseball(Arrays.asList(1,1,3))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 범위_벗어난_숫자_exception_반환() {
        assertThatThrownBy(() -> new Baseball(Arrays.asList(1,3,10))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수_포함_exception_반환() {
        assertThatThrownBy(() -> new Baseball(Arrays.asList(-1,3,8))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void countStrike_올바른_반환값() {
        Baseball baseball1 = new Baseball(Arrays.asList(1,2,3));
        Baseball baseball2 = new Baseball(Arrays.asList(1,5,3));
        assertThat(baseball1.countStrike(baseball2)).isEqualTo(2);
    }

    @Test
    void countBall_올바른_반환값() {
        Baseball baseball1 = new Baseball(Arrays.asList(1,2,3));
        Baseball baseball2 = new Baseball(Arrays.asList(3,5,2));
        assertThat(baseball1.countBall(baseball2)).isEqualTo(2);
    }
}