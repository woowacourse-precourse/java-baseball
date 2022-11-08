package baseball.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallGeneratorTest {

    private BallGenerator ballGenerator;

    @BeforeEach
    void initial() {
        ballGenerator = new BallGenerator();
    }

    @Test
    void 컴퓨터_공은_3개여야_합니다() {
        List<Integer> computerBalls = ballGenerator.createComputerBalls();

        assertThat(computerBalls.size())
                .isEqualTo(3);
    }

    @Test
    void 컴퓨터_공은_1부터_9까지_범위여야_합니다() {
        List<Integer> computerBalls = ballGenerator.createComputerBalls();

        assertThat(computerBalls.stream().allMatch(ball -> ball >= 1 && ball <= 9))
                .isTrue();
    }

    @Test
    void 사용자_공이_3개가_아니라면_예외가_발생합니다() {
        String input = "1234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> {
            ballGenerator.createPlayerBalls();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자_공에_1부터_9까지가_아닌_수가_포함되면_예외가_발생합니다() {
        String input = "120";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> {
            ballGenerator.createPlayerBalls();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자_공에_중복이_포함되면_예외가_발생합니다() {
        String input = "122";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> {
            ballGenerator.createPlayerBalls();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
