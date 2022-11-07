package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BallGeneratorTest {

    @Test
    void 컴퓨터_공_개수_테스트() {
        // given
        final BallGenerator ballGenerator = new BallGenerator();

        // when
        List<Integer> computerBalls = ballGenerator.createComputerBalls();

        // then
        assertThat(computerBalls.size())
                .isEqualTo(3);
    }

    @Test
    void 컴퓨터_공_범위_테스트() {
        // given
        final BallGenerator ballGenerator = new BallGenerator();

        // when
        List<Integer> computerBalls = ballGenerator.createComputerBalls();

        // then
        assertThat(computerBalls.stream().allMatch(ball -> ball >= 1 && ball <= 9))
                .isTrue();
    }

    @Test
    void 사용자_공_개수_테스트_X() {
        // given
        String input = "1234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        final BallGenerator ballGenerator = new BallGenerator();

        // when
        Throwable exception = assertThrows(RuntimeException.class, () -> ballGenerator.createPlayerBalls());

        // then
        assertEquals(IllegalArgumentException.class, exception.getClass());
    }

    @Test
    void 사용자_공_범위_테스트_X() {
        // given
        String input = "120";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        final BallGenerator ballGenerator = new BallGenerator();

        // when
        Throwable exception = assertThrows(RuntimeException.class, () -> ballGenerator.createPlayerBalls());

        // then
        assertEquals(IllegalArgumentException.class, exception.getClass());
    }

    @Test
    void 사용자_공_중복_테스트_X() {
        // given
        String input = "122";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        final BallGenerator ballGenerator = new BallGenerator();

        // when
        Throwable exception = assertThrows(RuntimeException.class, () -> ballGenerator.createPlayerBalls());

        // then
        assertEquals(IllegalArgumentException.class, exception.getClass());
    }
}
