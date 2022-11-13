package bestpractice.baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class RefereeTest {

    private static final List<Integer> ANSWER = Arrays.asList(1, 2, 3);
    private Referee referee;

    @BeforeEach
    void setUp() {
        referee = new Referee();
    }

    @Test
    void 스트라이크3() {
        String result = referee.compare(ANSWER, List.of(1, 2, 3));

        Assertions.assertThat(result).isEqualTo("0볼 3스트라이크");
    }

    @Test
    void 낫싱() {
        String result = referee.compare(ANSWER, List.of(4, 5, 6));

        Assertions.assertThat(result).isEqualTo("낫싱");
    }

    @Test
    void 볼3() {
        String result = referee.compare(ANSWER, List.of(3, 1, 2));

        Assertions.assertThat(result).isEqualTo("3볼 0스트라이크");
    }
}