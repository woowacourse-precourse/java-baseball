package baseball.domain;

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

    @Test
    void 판정에_따른_경기결과_객체를_생성한다() {
        // given
        Referee referee = new Referee();

        // when
        GameResult gameResult = referee.judge("123", "123");

        // then
        assertThat(gameResult).isNotNull();
    }

    @Test
    void 판정에_의해_생성된_경기결과는_스트라이크_볼_개수를_가진다1() {
        // given
        Referee referee = new Referee();
        int expectedStrike = 1;
        int expectedBall = 2;

        // when
        GameResult gameResult = referee.judge("123", "132");

        // then
        assertThat(gameResult.getStrikeCount()).isEqualTo(expectedStrike);
        assertThat(gameResult.getBallCount()).isEqualTo(expectedBall);
    }

    @Test
    void 판정에_의해_생성된_경기결과는_스트라이크_볼_개수를_가진다2() {
        // given
        Referee referee = new Referee();
        int expectedStrike = 3;
        int expectedBall = 0;

        // when
        GameResult gameResult = referee.judge("123", "123");

        // then
        assertThat(gameResult.getStrikeCount()).isEqualTo(expectedStrike);
        assertThat(gameResult.getBallCount()).isEqualTo(expectedBall);
    }

    @Test
    void 판정에_의해_생성된_경기결과는_스트라이크_볼_개수를_가진다3() {
        // given
        Referee referee = new Referee();
        int expectedStrike = 0;
        int expectedBall = 3;

        // when
        GameResult gameResult = referee.judge("123", "312");

        // then
        assertThat(gameResult.getStrikeCount()).isEqualTo(expectedStrike);
        assertThat(gameResult.getBallCount()).isEqualTo(expectedBall);
    }
}