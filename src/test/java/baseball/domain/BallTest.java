package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {
    public static final Ball ONE_FIVE = new Ball(1, 5);
    
    @Test
    @DisplayName("strike")
    void strike() {
        assertThat(ONE_FIVE.compareOneBall(new Ball(1, 5))).isEqualTo(BallStatus.STRIKE);
    }
    
    @Test
    @DisplayName("ball")
    void ball() {
        assertThat(ONE_FIVE.compareOneBall(new Ball(2, 5))).isEqualTo(BallStatus.BALL);
    }
    
    @Test
    @DisplayName("nothing")
    void nothing() {
        assertThat(ONE_FIVE.compareOneBall(new Ball(2, 6))).isEqualTo(BallStatus.NOTHING);
    }
}
