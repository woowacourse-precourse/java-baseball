package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class BallsTest2 {
    Balls computer;

    @BeforeEach
    void init() {
        computer = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    void nothing() {
        Result result = computer.play(Arrays.asList(4, 5, 6));
        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getStrike()).isEqualTo(0);
    }

    @Nested
    class NBallTest {
        @Test
        void one_ball() {
            Result result = computer.play(Arrays.asList(3, 5, 6));
            assertThat(result.getBall()).isEqualTo(1);
            assertThat(result.getStrike()).isEqualTo(0);
        }

        @Test
        void two_ball() {
            Result result = computer.play(Arrays.asList(3, 1, 6));
            assertThat(result.getBall()).isEqualTo(2);
            assertThat(result.getStrike()).isEqualTo(0);
        }

        @Test
        void three_ball() {
            Result result = computer.play(Arrays.asList(3, 1, 2));
            assertThat(result.getBall()).isEqualTo(3);
            assertThat(result.getStrike()).isEqualTo(0);
        }
    }

}
