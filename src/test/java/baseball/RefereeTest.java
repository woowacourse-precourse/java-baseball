package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class RefereeTest {

    Referee referee = new Referee();

    @Test
    void 심판_초기화시_스트라이크_볼_개수는_모두_0이다() {
        // given
        int expectedStrike = 0;
        int expectedBall = 0;

        // when
        referee.initCount();

        // then
        assertThat(referee.getStrikeCount()).isEqualTo(expectedStrike);
        assertThat(referee.getBallCount()).isEqualTo(expectedBall);
    }
}