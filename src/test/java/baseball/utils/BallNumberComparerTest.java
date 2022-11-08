package baseball.utils;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.BallNumber;
import baseball.domain.Score;
import java.util.List;
import org.junit.jupiter.api.Test;

class BallNumberComparerTest {
    private final BallNumberComparer ballNumberComparer = new BallNumberComparer();
    @Test
    public void calculateScoreSuccessTest1() throws Exception {
        // given
        BallNumber playerBallNumber = BallNumber.fromIntegerList(List.of(1, 2, 3));
        BallNumber computerBallNumber = BallNumber.fromIntegerList(List.of(3, 2, 1));

        // when
        Score score = ballNumberComparer.calculateScore(playerBallNumber, computerBallNumber);

        // then
        assertThat(score.getStrike()).isEqualTo(1);
        assertThat(score.getBall()).isEqualTo(2);
    }

    @Test
    public void calculateScoreSuccessTest2() throws Exception {
        // given
        BallNumber playerBallNumber = BallNumber.fromIntegerList(List.of(1, 2, 3));
        BallNumber computerBallNumber = BallNumber.fromIntegerList(List.of(4, 5, 6));

        // when
        Score score = ballNumberComparer.calculateScore(playerBallNumber, computerBallNumber);

        // then
        assertThat(score.getStrike()).isEqualTo(0);
        assertThat(score.getBall()).isEqualTo(0);
    }
}