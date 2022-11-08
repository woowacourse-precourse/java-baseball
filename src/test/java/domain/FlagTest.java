package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FlagTest {
    @Test
    void 종료_값이_1_또는_2가_아니면_예외처리() {
        assertThatThrownBy(() -> new Flag("3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("재시작 / 종료 값은 1 또는 2가 되어야 합니다.");
    }
}