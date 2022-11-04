package baseball;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class BallsTest {

    @Test
    void 이미_있는_숫자와_겹치는지_확인하는_기능() {
        // given
        Balls balls = new Balls();
        balls.addBall(new Ball(1));

        // then
        assertThat(balls.checkDuplicate(new Ball(1))).isTrue();
        assertThat(balls.checkDuplicate(new Ball(2))).isFalse();
    }

    @Test
    void 세자리_숫자를_만들어주는_기능() {
        // given
        Balls balls = new Balls();

        // when
        balls.generate();

        //then
        assertThat(balls.size()).isEqualsTo(3);
        assertThat(balls.getBallList().stream().allMatch(number) -> 1 <= number && number <= 9).isTrue();
    }
}
