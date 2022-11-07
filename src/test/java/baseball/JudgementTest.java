package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.Judgement;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
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
    @CsvSource(value = {"5, 1, 6, 1볼", "1, 3, 8, 1볼 1스트라이크", "1, 2, 3, 3스트라이크", "4, 5, 6, 낫싱"})
    void getJudgementResult(int number1, int number2, int number3, String expected) {
        List<Integer> playerNumbers = List.of(number1, number2, number3);
        String actual = judgement.getJudgementResult(computerNumbers, playerNumbers);
        assertThat(actual).isEqualTo(expected);
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