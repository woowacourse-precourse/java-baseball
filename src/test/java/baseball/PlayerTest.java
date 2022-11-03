package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    @Test
    void 입력값이_3개의_숫자가아니면_예외발생() {
        assertThatThrownBy(() -> new Player(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 3개의 숫자여야 합니다.");
    }
}
