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

    @ParameterizedTest
    @CsvSource(value = {"3, 4, 5, 1", "3, 2, 5, 2", "3, 2, 1, 3", "4, 5, 6, 0"})
    void countSameNumbers(int number1, int number2, int number3, int expected) {
        List<Integer> playerNumbers = List.of(number1, number2, number3);
        int actual = judgement.countSameNumbers(computerNumbers, playerNumbers);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void _0개의_위치가_같다() {
        List<Integer> playerNumbers = List.of(3, 4, 5);
        int count = judgement.countSamePosition(computerNumbers, playerNumbers);

        assertThat(count).isZero();
    }

    @Test
    void _1개의_위치가_같다() {
        List<Integer> playerNumbers = List.of(3, 2, 5);
        int count = judgement.countSamePosition(computerNumbers, playerNumbers);

        assertThat(count).isEqualTo(1);
    }

    @Test
    void _2개의_위치가_같다() {
        List<Integer> playerNumbers = List.of(1, 2, 5);
        int count = judgement.countSamePosition(computerNumbers, playerNumbers);

        assertThat(count).isEqualTo(2);
    }

    @Test
    void _3개의_위치가_같다() {
        List<Integer> playerNumbers = List.of(1, 2, 3);
        int count = judgement.countSamePosition(computerNumbers, playerNumbers);

        assertThat(count).isEqualTo(3);
    }
}