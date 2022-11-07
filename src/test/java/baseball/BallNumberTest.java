package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallNumberTest {
    @Test
    void 숫지가_1과9사이가_아니라면_오류를_던진다() {
        int testNumber = 10;

        assertThatThrownBy(() -> new BallNumber(testNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
