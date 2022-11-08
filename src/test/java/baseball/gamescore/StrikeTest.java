package baseball.gamescore;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StrikeTest {
    @Test
    void 스트라이크1_맞는지_확인() {
        Strike strike = new Strike();
        int score = strike.score(List.of(1, 6, 3), List.of(1, 2, 5));
        int result = 1;
        assertThat(score).isEqualTo(result);
    }

    @Test
    void 스트라이크3_맞는지_확인() {
        Strike strike = new Strike();
        int score = strike.score(List.of(1, 2, 3), List.of(1, 2, 3));
        int result = 3;
        assertThat(score).isEqualTo(result);
    }
}