package baseball.domain;

import baseball.domain.GameResult;
import baseball.domain.Referee;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RefereeTest {

    Referee referee = new Referee();

    @Test
    void 정답인_경우_스트라이크_개수는_3이다() {
        // given
        String answer = "123";
        String userNumber = "123";

        int expectedStrike = 3;
        int expectedBall = 0;

        // when
        GameResult gameResult = referee.judge(answer, userNumber);

        // then
        assertThat(gameResult.getStrikeCount()).isEqualTo(expectedStrike);
        assertThat(gameResult.getBallCount()).isEqualTo(expectedBall);
    }

    @Test
    void 스트라이크_1개이상_볼_1개이상_존재한다() {
        // given
        String answer = "123";
        String userNumber = "134";

        int expectedStrike = 1;
        int expectedBall = 1;

        // when
        GameResult gameResult = referee.judge(answer, userNumber);

        // then
        assertThat(gameResult.getStrikeCount()).isEqualTo(expectedStrike);
        assertThat(gameResult.getBallCount()).isEqualTo(expectedBall);
    }

    @Test
    void 스트라이크만_존재하는_경우_볼은_0이다() {
        // given
        String answer = "123";
        String userNumber = "127";

        int expectedStrike = 2;
        int expectedBall = 0;

        // when
        GameResult gameResult = referee.judge(answer, userNumber);

        // then
        assertThat(gameResult.getStrikeCount()).isEqualTo(expectedStrike);
        assertThat(gameResult.getBallCount()).isEqualTo(expectedBall);
    }


    @Test
    void 볼만_존재하는_경우_스트라이크는_0이다() {
        // given
        String answer = "123";
        String userNumber = "312";

        int expectedStrike = 0;
        int expectedBall = 3;

        // when
        GameResult gameResult = referee.judge(answer, userNumber);

        // then
        assertThat(gameResult.getStrikeCount()).isEqualTo(expectedStrike);
        assertThat(gameResult.getBallCount()).isEqualTo(expectedBall);
    }

    @Test
    void 볼과_스트라이크가_모두_없는_경우_모두_0개이다() {
        // given
        String answer = "123";
        String userNumber = "987";

        int expectedStrike = 0;
        int expectedBall = 0;

        // when
        GameResult gameResult = referee.judge(answer, userNumber);

        // then
        assertThat(gameResult.getStrikeCount()).isEqualTo(expectedStrike);
        assertThat(gameResult.getBallCount()).isEqualTo(expectedBall);
    }
}