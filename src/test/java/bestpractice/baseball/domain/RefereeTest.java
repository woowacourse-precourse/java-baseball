package bestpractice.baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    private static final List<Integer> ANSWER = Arrays.asList(1, 2, 3);
    private Referee referee;

    @BeforeEach
    void setUp() {
        referee = new Referee();
    }


    @ParameterizedTest
    @CsvSource({"1,2,3,0볼 3스트라이크", "7,8,9,낫싱", "2,3,1,3볼 0스트라이크"})
    public void compare(int number1, int number2, int number3, String expected) {
        String actual = referee.compare(ANSWER, Arrays.asList(number1, number2, number3));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 스트라이크3() {

        String result = referee.compare(ANSWER, List.of(1, 2, 3));

        assertThat(result).isEqualTo("0볼 3스트라이크");
    }

    @Test
    void 낫싱() {
        String result = referee.compare(ANSWER, List.of(4, 5, 6));

        assertThat(result).isEqualTo("낫싱");
    }

    @Test
    void 볼3() {
        String result = referee.compare(ANSWER, List.of(3, 1, 2));

        assertThat(result).isEqualTo("3볼 0스트라이크");
    }
}