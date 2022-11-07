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

    @Test
    void countOut() {
        //given
        Referee referee = new Referee();
        referee.scoreStrikeAndBallCount(new int[]{1,2,3},new int[]{1,2,3});

        //when
        boolean result = referee.countOut();

        //then
        assertThat(referee.getStrike()).isEqualTo(COUNT_VALUE);
        assertThat(result).isTrue();
    }

}