package baseball.util;

import baseball.number.NumberDto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static baseball.util.Validation.validateNumberNotRepeated;
import static org.assertj.core.api.Assertions.assertThat;

class ValidationTest {
    @Test
    void 정상_숫자_검증() {
        assertThat(validateNumberNotRepeated(new NumberDto(Arrays.asList(1, 2, 3))))
                .isTrue();
    }

    @Test
    void 중복_숫자_검증() {
        assertThat(validateNumberNotRepeated(new NumberDto(Arrays.asList(1, 2, 2))))
                .isFalse();

    }
}