package baseball.domain.count.ball;

import baseball.domain.count.ball.BallCounter;
import baseball.domain.count.ball.BallResult;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BallCounterTest {
    
    private final BallCounter ballCounter = new BallCounter();

    @Test
    void ball의_개수가_3개일_경우() {
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> inputNumber = List.of(3, 1, 2);
        BallResult ballResult = ballCounter.checkBall(answer, inputNumber);

        assertThat(ballResult.ballCount()).isEqualTo(3);
    }

    @Test
    void ball의_개수가_0개일_경우() {
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> inputNumber = List.of(1, 2, 3);
        BallResult ballResult = ballCounter.checkBall(answer, inputNumber);

        assertThat(ballResult.ballCount()).isEqualTo(0);
    }
}