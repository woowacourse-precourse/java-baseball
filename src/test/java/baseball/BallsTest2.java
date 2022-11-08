package baseball;

import baseball.domain.Balls;
import baseball.domain.Result;
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

    @Nested
    class NStrikeTest {
        @Test
        void one_strike() {
            Result result = computer.play(Arrays.asList(1, 4, 5));
            assertThat(result.getBall()).isEqualTo(0);
            assertThat(result.getStrike()).isEqualTo(1);
        }

        @Test
        void two_strike() {
            Result result = computer.play(Arrays.asList(1, 2, 5));
            assertThat(result.getBall()).isEqualTo(0);
            assertThat(result.getStrike()).isEqualTo(2);
        }

        @Test
        void three_strike() {
            Result result = computer.play(Arrays.asList(1, 2, 3));
            assertThat(result.getBall()).isEqualTo(0);
            assertThat(result.getStrike()).isEqualTo(3);
        }
    }

    @Nested
    class NBallNStrike {
        @Test
        void oneBall_oneStrike() {
            Result result = computer.play(Arrays.asList(1, 3, 5));
            assertThat(result.getBall()).isEqualTo(1);
            assertThat(result.getStrike()).isEqualTo(1);
        }

        @Test
        void twoBall_OneStrike() {
            Result result = computer.play(Arrays.asList(1, 3, 2));
            assertThat(result.getBall()).isEqualTo(2);
            assertThat(result.getStrike()).isEqualTo(1);
        }
    }

    @Nested
    class getResultToString {
        @Test
        void oneBall_oneStrike() {
            assertThat(computer.play(Arrays.asList(1, 3, 5)).toString()).isEqualTo("1볼 1스트라이크");
        }

        @Test
        void twoBall_OneStrike() {
            assertThat(computer.play(Arrays.asList(1, 3, 2)).toString()).isEqualTo("2볼 1스트라이크");
        }
    }
}
