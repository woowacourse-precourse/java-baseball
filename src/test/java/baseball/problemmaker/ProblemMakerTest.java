package baseball.problemmaker;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.Numbers;
import baseball.dto.BallCount;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ProblemMakerTest {

    @Test
    void findBallCount_메서드_사용시_몇스트라이크_몇볼인지_반환_3스트라이크() {
        Numbers numbers = new Numbers(List.of(1, 2, 3));
        ProblemMaker problemMaker = new Computer(numbers);

        BallCount ballCount = problemMaker.findBallCount(numbers);
        assertThat(ballCount.getStrike()).isEqualTo(3);
        assertThat(ballCount.getBall()).isEqualTo(0);
    }

    @Test
    void findBallCount_메서드_사용시_몇스트라이크_몇볼인지_반환_0스트라이크_0볼() {
        Numbers numbers = new Numbers(List.of(1, 2, 3));
        ProblemMaker problemMaker = new Computer(numbers);

        numbers = new Numbers(List.of(4, 5, 6));
        BallCount ballCount = problemMaker.findBallCount(numbers);
        assertThat(ballCount.getStrike()).isEqualTo(0);
        assertThat(ballCount.getBall()).isEqualTo(0);
    }

    @Test
    void findBallCount_메서드_사용시_몇스트라이크_몇볼인지_반환_1스트라이크_2볼() {
        Numbers numbers = new Numbers(List.of(1, 2, 3));
        ProblemMaker problemMaker = new Computer(numbers);

        numbers = new Numbers(List.of(1, 3, 2));
        BallCount ballCount = problemMaker.findBallCount(numbers);
        assertThat(ballCount.getStrike()).isEqualTo(1);
        assertThat(ballCount.getBall()).isEqualTo(2);
    }
}
