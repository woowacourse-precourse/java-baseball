package baseball.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StrikeTest {
    @DisplayName("Strike이 범위 안에서는 문제 없이 생성됨")
    @Test
    void Strike_범위_안() {
        assertThat(Strike.from(0)).isEqualTo(Strike.ZERO);
        assertThat(Strike.from(1)).isEqualTo(Strike.ONE);
        assertThat(Strike.from(2)).isEqualTo(Strike.TWO);
        assertThat(Strike.from(3)).isEqualTo(Strike.THREE);
    }

    @DisplayName("Strike이 범위 밖에서는 예외 발생")
    @Test
    void Strike_범위_밖() {
        assertThrows(IllegalArgumentException.class, () -> Strike.from(-1));
        assertThrows(IllegalArgumentException.class, () -> Strike.from(4));
    }
}
