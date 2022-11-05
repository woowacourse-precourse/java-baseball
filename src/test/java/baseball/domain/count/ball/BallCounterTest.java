package baseball.domain.count.ball;

import baseball.domain.number.SingleNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BallCounterTest {
    
    private final BallCounter ballCounter = new BallCounter();

    @Test
    void ball이_3개인_경우_ballCount는_3이다() {
        List<SingleNumber> randomNumbers = List.of(
                new SingleNumber(0, 1),
                new SingleNumber(1, 2),
                new SingleNumber(2, 3)
        );

        List<SingleNumber> inputNumbers = List.of(
                new SingleNumber(0, 3),
                new SingleNumber(1, 1),
                new SingleNumber(2, 2)
        );

        BallResult ballResult = ballCounter.checkBall(randomNumbers, inputNumbers);
        assertThat(ballResult.ballCount()).isEqualTo(3);
    }

    @Test
    void ball이_0개인_경우_ballCount는_0이다() {
        List<SingleNumber> randomNumbers = List.of(
                new SingleNumber(0, 1),
                new SingleNumber(1, 2),
                new SingleNumber(2, 3)
        );

        List<SingleNumber> inputNumbers = List.of(
                new SingleNumber(0, 1),
                new SingleNumber(1, 2),
                new SingleNumber(2, 3)
        );

        BallResult ballResult = ballCounter.checkBall(randomNumbers, inputNumbers);
        assertThat(ballResult.ballCount()).isEqualTo(0);
    }
}