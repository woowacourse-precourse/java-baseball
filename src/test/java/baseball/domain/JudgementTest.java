package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class JudgementTest {
    private final List<Integer> computerNumbers = List.of(1, 2, 3);
    private Judgement judgement;

    @BeforeEach
    void setUp() {
        judgement = new Judgement();
    }

    @Test
    void _1볼() {
        String actual = judgement.getJudgementResult(computerNumbers, List.of(5, 1, 6));
        assertThat(actual).isEqualTo("1볼");
    }

    @Test
    void _1볼_1스트라이크() {
        String actual = judgement.getJudgementResult(computerNumbers, List.of(1, 3, 8));
        assertThat(actual).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void _3스트라이크() {
        String actual = judgement.getJudgementResult(computerNumbers, List.of(1, 2, 3));
        assertThat(actual).isEqualTo("3스트라이크");
    }

    @Test
    void _낫싱() {
        String actual = judgement.getJudgementResult(computerNumbers, List.of(6, 7, 8));
        assertThat(actual).isEqualTo("낫싱");
    }

    @ParameterizedTest
    @CsvSource(value = {"3, 4, 5, 1", "3, 2, 5, 2", "3, 2, 1, 3", "4, 5, 6, 0"})
    void countSameNumbers(int number1, int number2, int number3, int expected) {
        List<Integer> playerNumbers = List.of(number1, number2, number3);
        int actual = judgement.countSameNumbers(computerNumbers, playerNumbers);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"3, 2, 5, 1", "1, 2, 5, 2", "1, 2, 3, 3", "3, 4, 5, 0"})
    void countSamePosition(int number1, int number2, int number3, int expected) {
        List<Integer> playerNumbers = List.of(number1, number2, number3);
        int actual = judgement.countSamePosition(computerNumbers, playerNumbers);

        assertThat(actual).isEqualTo(expected);
    }
}