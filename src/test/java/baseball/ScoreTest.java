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
}
