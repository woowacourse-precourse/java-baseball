package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallsTest {
    private Balls balls;
    
    @BeforeEach
    void setUp() {
        balls = new Balls("123");
    }
    
    @Test
    @DisplayName("strike 인 공이 존재")
    void strike() {
        assertThat(balls.compareOneBallInOrder(new Ball(1, 2))).isEqualTo(BallStatus.STRIKE);
    }
    
    @Test
    @DisplayName("ball 인 공이 존재")
    void ball() {
        assertThat(balls.compareOneBallInOrder(new Ball(0, 2))).isEqualTo(BallStatus.BALL);
    }
    
    @Test
    @DisplayName("strike, ball 인 공이 없는 경우")
    void nothing() {
        assertThat(balls.compareOneBallInOrder(new Ball(0, 5))).isEqualTo(BallStatus.NOTHING);
    }
}
