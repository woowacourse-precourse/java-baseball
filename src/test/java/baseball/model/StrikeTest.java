package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StrikeTest {

    Strike strike;
    String result = "1스트라이크";

    @BeforeEach
    void init() {
        strike = new Strike();
    }

    @Test
    void 스트라이크() {
        assertThat(strike.getScore()).isEqualTo(0);

        strike.count();
        assertThat(strike.getScore()).isEqualTo(1);
    }

    @Test
    void 쓰리스트라이크() {
        strike.count();
        strike.count();
        strike.count();
        assertThat(strike.isThreeStrike()).isTrue();
    }

    @Test
    void 결과_아웃인경우() {
        assertThat(strike.result()).isEqualTo("");
    }

    @Test
    void 결과_스트라이크인경우() {
        strike.count();
        assertThat(strike.result()).isEqualTo(result);
    }
}
