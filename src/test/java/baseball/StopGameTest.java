package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StopGameTest {

    @Test
    void resumeGame() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("1".getBytes());
        System.setIn(inputStream);
        assertThat(StopGame.isStop()).isEqualTo(0);
    }

    @Test
    void stopGame() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("2".getBytes());
        System.setIn(inputStream);
        assertThat(StopGame.isStop()).isEqualTo(1);
    }

    @Test
    void wrongStopInput() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("3".getBytes());
        System.setIn(inputStream);
        assertThatThrownBy(() -> StopGame.isStop())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
