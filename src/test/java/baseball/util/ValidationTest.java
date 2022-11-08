package baseball.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static baseball.util.Validation.validateNumberNotRepeated;
import static org.assertj.core.api.Assertions.assertThat;

class ValidationTest {
    @Test
    void 정상_숫자() {
        assertThat(validateNumberNotRepeated(Arrays.asList(1, 2, 3), 3))
                .isTrue();
    }

    @Test
    void 중복_숫자() {
        assertThat(validateNumberNotRepeated(Arrays.asList(1, 2, 2), 3))
                .isFalse();

    }
}