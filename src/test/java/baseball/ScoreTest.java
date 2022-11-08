package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ScoreTest {

    Score score = new Score();

    @Test
    void 스코어의_초기값은_낫싱이다() {
        Assertions.assertThat(score.getScore()).isEqualTo("낫싱");
    }

    @Test
    void 스트라이크_1점_추가() {
        score.plusStrike();
        Assertions.assertThat(score.getScore()).isEqualTo("1스트라이크");
    }

    @Test
    void 볼_1점_추가() {
        score.plusBall();
        Assertions.assertThat(score.getScore()).isEqualTo("1볼");
    }
}