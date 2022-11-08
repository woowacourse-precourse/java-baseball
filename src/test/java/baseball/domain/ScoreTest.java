package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ScoreTest {
    @Test
    public void scoreToStringSuccessTest() throws Exception {
        // given
        Score score1 = new Score(0, 0);
        Score score2 = new Score(2, 0);
        Score score3 = new Score(0, 2);
        Score score4 = new Score(1, 1);

        // when
        String scoreString1 = score1.toString();
        String scoreString2 = score2.toString();
        String scoreString3 = score3.toString();
        String scoreString4 = score4.toString();

        // then
        assertThat(scoreString1).isEqualTo("낫싱");
        assertThat(scoreString2).isEqualTo("2스트라이크");
        assertThat(scoreString3).isEqualTo("2볼 ");
        assertThat(scoreString4).isEqualTo("1볼 1스트라이크");
    }
}
