package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RefereeTest {
    private static final List<Integer> ANSWER = Arrays.asList(1, 2, 3);
    private Referee referee;

    @BeforeEach
    void serUp() {
        referee = new Referee();
    }


    @Test
    void 스트라이크3() {
        String result = referee.compare(ANSWER, ANSWER);
        assertThat(result).isEqualTo("3스트라이크");
    }

    @Test
    void 낫싱() {
        String result = referee.compare(Arrays.asList(7, 8, 9), ANSWER);
        assertThat(result).isEqualTo("낫싱");
    }

    @Test
    void 볼() {
        String result = referee.compare(Arrays.asList(1, 3, 2), ANSWER);
        assertThat(result).isEqualTo("2볼 1스트라이크");
    }
}