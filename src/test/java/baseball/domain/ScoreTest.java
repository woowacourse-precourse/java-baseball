package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ScoreTest {
    @Test
    void 점수에_따른_올바른_상태를_반환() {
        //given
        Score testScore = new Score(1, 2);

        //when
        CountStatus countStatus = testScore.getCountStatus();

        //then
        assertThat(countStatus).isEqualTo(CountStatus.BALL_AND_STRIKE);
    }

    @Test
    void 상태에_따른_올바른_횟수를_반환() {
        //given
        int strikeCount = 1;
        int ballCount = 2;
        Score testScore = new Score(ballCount, strikeCount);
        CountStatus countStatus = testScore.getCountStatus();

        //when
        List<Integer> strikeAndBallCount = testScore.getStrikeAndBallCount(countStatus);

        //then
        assertThat(strikeAndBallCount).isEqualTo(List.of(ballCount, strikeCount));
    }
}
