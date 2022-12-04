package baseball.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    @Test
    public void resultTest() {
        Result result = Result.of(3,0);
        assertThat(result.getBallCount()).isEqualTo(3);
        assertThat(result.getStrickCount()).isEqualTo(0);
    }
}
