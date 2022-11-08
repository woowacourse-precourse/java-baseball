package baseball;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class BallTest {

    @Test
    void 유효한_숫자가_아니면_에러를_던진다() {
        assertThatThrownBy(() -> new Ball(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효한 숫자 범위가 아닙니다.");
    }

}