package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BallsTest {

    @Test
    public void ballSizeExceptionTest() throws Exception {
        List<Integer> integers = List.of(1234);
        Assertions.assertThatThrownBy(() -> Balls.from(integers))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
