package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void createPlayer() {
        assertThatCode(() -> new Player())
                .doesNotThrowAnyException();
    }
}