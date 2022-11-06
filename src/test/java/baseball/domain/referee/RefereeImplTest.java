package baseball.domain.referee;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RefereeImplTest {

    @Test
    void isEndGameSetTest() {
        //given
        Referee referee = new RefereeImpl();

        String resultMessage1 = "3스트라이크";
        String resultMessage2 = "1볼 2스트라이크";

        //when
        boolean endGameSetResult1 = referee.isEndGameSet(resultMessage1);
        boolean endGameSetResult2 = referee.isEndGameSet(resultMessage2);

        //then
        assertThat(endGameSetResult1).isEqualTo(true);
        assertThat(endGameSetResult2).isEqualTo(false);

    }


}
