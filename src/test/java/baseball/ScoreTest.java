package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ScoreTest {

    @Test
    void setBall_볼의_개수가_수정_반환_되는지_확인() {
        int input = 2;
        Score score = new Score();
        score.setBall(input);

        assertThat(score.getBall()).isEqualTo(input);
    }

    @Test
    void setBall_스트라이크의_개수가_수정_반환_되는지_확인() {
        int input = 3;
        Score score = new Score();
        score.setStrike(input);

        assertThat(score.getStrike()).isEqualTo(input);
    }
}
