package baseball;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class BallsTest {

    @Test
    void 이미_있는_숫자와_겹치는지_확인하는_기능() {
        Balls balls = new Balls(List.of(new Ball(1)));

        assertThat(balls.checkDuplicate(1)).isTrue();
        assertThat(balls.checkDuplicate(2)).isFalse();
    }
}
