package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerInputTest {
    @DisplayName("Player input은 100~999사이의 값만 받는다")
    @Test
    void playerInputTest() {
        assertThrows(IllegalArgumentException.class, () -> PlayerInput.from(99));
        assertThrows(IllegalArgumentException.class, () -> PlayerInput.from(1000));
        assertDoesNotThrow(() -> PlayerInput.from(123));
        assertDoesNotThrow(() -> PlayerInput.from(987));
    }

    @DisplayName("Player input은 중복 값을 받지 않는다")
    @Test
    void 중복_체크() {
        assertThrows(IllegalArgumentException.class, () -> PlayerInput.from(112));
        assertThrows(IllegalArgumentException.class, () -> PlayerInput.from(122));
        assertThrows(IllegalArgumentException.class, () -> PlayerInput.from(212));
    }
}
