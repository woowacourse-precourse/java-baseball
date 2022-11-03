package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ValidationTest {

    @Test
    void ballRangeValidationTest() {
        assertThat(ValidationUtil.isValidRange(List.of(1, 2, 3))).isTrue();
        assertThat(ValidationUtil.isValidRange(List.of(9, 8, 7))).isTrue();
        assertThat(ValidationUtil.isValidRange(List.of(0, 1))).isFalse();
        assertThat(ValidationUtil.isValidRange(List.of(9, 10))).isFalse();
    }

    @Test
    void ballCountValidationTest() {
        assertThat(ValidationUtil.isValidCount(List.of(1, 2, 3))).isTrue();
        assertThat(ValidationUtil.isValidCount(List.of(9, 8, 7))).isTrue();

        assertThat(ValidationUtil.isValidCount(List.of(1, 2))).isFalse();
        assertThat(ValidationUtil.isValidCount(List.of(8, 9))).isFalse();

        assertThat(ValidationUtil.isValidCount(List.of(1, 2, 3, 4))).isFalse();
        assertThat(ValidationUtil.isValidCount(List.of(9, 8, 7, 6))).isFalse();
    }

    @Test
    void duplicatedNumTest() {
        assertThat(ValidationUtil.haveNoDuplicatedNum(List.of(1, 2, 3))).isTrue();
        assertThat(ValidationUtil.haveNoDuplicatedNum(List.of(1, 1, 3))).isFalse();
        assertThat(ValidationUtil.haveNoDuplicatedNum(List.of(1, 1, 1))).isFalse();
    }
}
