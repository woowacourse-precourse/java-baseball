package baseball.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UtilTest {

    @Test
    void 양수_확인() {
        assertThat(Number.isPositive(5)).isEqualTo(true);
        assertThat(Number.isPositive(10)).isEqualTo(true);
        assertThat(Number.isPositive(-5)).isEqualTo(false);
        assertThat(Number.isPositive(0)).isEqualTo(false);
    }

}
