package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ValidationTest {

    @Test
    void ballRangeValidationTest() {
        assertThat(ValidationUtil.isValidRange(List.of(1))).isTrue();
        assertThat(ValidationUtil.isValidRange(List.of(9))).isTrue();
        assertThat(ValidationUtil.isValidRange(List.of(0))).isFalse();
        assertThat(ValidationUtil.isValidRange(List.of(10))).isFalse();
    }
}
