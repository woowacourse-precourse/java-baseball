package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    @Test
    void constructorTest() {
        Result result = new Result();
        int answer = 0;
        assertThat(result.getBall()).isEqualTo(answer);
        assertThat(result.getStrike()).isEqualTo(answer);
    }
}
