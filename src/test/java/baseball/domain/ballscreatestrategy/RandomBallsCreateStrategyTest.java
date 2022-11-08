package baseball.domain.ballscreatestrategy;

import baseball.domain.Ball;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomBallsCreateStrategyTest {
    @Test
    @DisplayName("Random Balls 생성")
    void create_computer_balls() {
        BallsCreateStrategy ballsCreateStrategy =
                () -> List.of(new Ball(0, 4), new Ball(1, 5), new Ball(2, 2));
        
        final List<Ball> expectedComputerBalls = List.of(new Ball(0, 4), new Ball(1, 5), new Ball(2, 2));
        assertThat(ballsCreateStrategy.create()).isEqualTo(expectedComputerBalls);
    }
}