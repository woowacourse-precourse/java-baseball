package baseball.domain.factory;

import baseball.domain.Ball;
import baseball.domain.BallStatus;
import baseball.domain.Balls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerBallsFactoryTest {
    @Test
    @DisplayName("Computer Balls 생성")
    void create_computer_balls() {
        Balls balls = ComputerBallsFactory.createComputerBalls(() -> List.of(new Ball(0, 4), new Ball(1, 5), new Ball(2, 2)));
        
        assertThat(balls.compareBalls(new Balls("415"))).isEqualTo(List.of(BallStatus.STRIKE, BallStatus.NOTHING, BallStatus.BALL));
    }
}