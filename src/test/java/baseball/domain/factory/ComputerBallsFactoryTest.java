package baseball.domain.factory;

import baseball.domain.Ball;
import baseball.domain.BallStatus;
import baseball.domain.Balls;
import baseball.domain.strategy.BallsCreateStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerBallsFactoryTest {
    @Test
    @DisplayName("Computer Balls 생성")
    void create_computer_balls() {
        final BallsCreateStrategy ballsCreateStrategy = () -> List.of(new Ball(0, 4), new Ball(1, 5), new Ball(2, 2));
        Balls balls = ComputerBallsFactory.createComputerBalls(ballsCreateStrategy);
    
        final List<BallStatus> expectedPitchResults = List.of(BallStatus.STRIKE, BallStatus.NOTHING, BallStatus.BALL);
        assertThat(balls.compareBalls(new Balls("415"))).isEqualTo(expectedPitchResults);
    }
}