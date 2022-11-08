package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UtilTest {
    @DisplayName("양수인지 확인한다")
    @Test
    void isPositive() {
        assertThat(Number.isPositive(5)).isEqualTo(true);
        assertThat(Number.isPositive(10)).isEqualTo(true);
        assertThat(Number.isPositive(-5)).isEqualTo(false);
        assertThat(Number.isPositive(0)).isEqualTo(false);
    }

}
