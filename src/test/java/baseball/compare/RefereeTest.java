package baseball.compare;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RefereeTest {

    @Test
    void judge_메소드는_서로_다른_수면_BALL을_반환() {
        assertThat(Referee.judge(0, 1)).isEqualTo(ComparisonResultType.BALL);
    }

    @Test
    void judge_메소드는_서로_같은_수면_STRIKE을_반환() {
        assertThat(Referee.judge(1, 1)).isEqualTo(ComparisonResultType.STRIKE);
    }
}
