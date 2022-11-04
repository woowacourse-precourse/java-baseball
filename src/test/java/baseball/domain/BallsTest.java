package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class BallsTest {

    @Test
    public void ballSizeExceptionTest() throws Exception {
        List<Integer> integers = List.of(1234);
        assertThatThrownBy(() -> Balls.from(integers))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void ballSameNumberExceptionTest() throws Exception {
        List<Integer> integers = List.of(778);
        assertThatThrownBy(() -> Balls.from(integers))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
