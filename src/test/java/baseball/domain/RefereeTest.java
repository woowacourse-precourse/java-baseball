package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    private static final int COUNT_VALUE = 3;

    @Test
    void scoreStrikeAndBallCount() {
        //given
        Referee referee = new Referee();

        //when
        referee.scoreStrikeAndBallCount(new int[]{1,2,3},new int[]{1,3,2});

        //then
        assertThat(referee.getStrike()).isEqualTo(1);
        assertThat(referee.getBall()).isEqualTo(2);
    }

}