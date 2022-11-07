package baseball.service;

import static baseball.Constants.MAX_RANGE;
import static baseball.Constants.MIN_RANGE;
import static baseball.Constants.TRIPLE_DIGITS;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Computer;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputerServiceTest {

    private ComputerService computerService;

    @BeforeEach
    void setUp() {
        computerService = new ComputerService();
    }

    @Test
    void generateNonDuplicateNumbers_메서드_사용시_서로_다른_세_자리_수를_생성() {
        //given
        List<Integer> result;

        //when
        result = computerService.generateNonDuplicateNumbers();

        //then
        assertThat(result).isNotNull();

        assertThat(result.size()).isEqualTo(TRIPLE_DIGITS);

        for (Integer number : result) {
            assertThat(number).isGreaterThanOrEqualTo(MIN_RANGE);
            assertThat(number).isLessThanOrEqualTo(MAX_RANGE);
        }

        Set<Integer> set = new HashSet<>(result);
        assertThat(set.size()).isEqualTo(TRIPLE_DIGITS);

        List<Integer> temp = computerService.generateNonDuplicateNumbers();
        assertThat(result).isNotSameAs(temp);
    }

    @Test
    void createAnswer_메서드_사용시_서로_다른_세_자리_수를_가진_Computer_객체_생성() {
        //given
        Computer computer;

        //when
        computer = computerService.createAnswer();
        List<Integer> result = computer.getAnswerNumbers();

        //then
        assertThat(result).isNotNull();

        assertThat(result.size()).isEqualTo(TRIPLE_DIGITS);

        for (Integer number : result) {
            assertThat(number).isGreaterThanOrEqualTo(MIN_RANGE);
            assertThat(number).isLessThanOrEqualTo(MAX_RANGE);
        }

        Set<Integer> set = new HashSet<>(result);
        assertThat(set.size()).isEqualTo(TRIPLE_DIGITS);

        List<Integer> temp = computerService.generateNonDuplicateNumbers();
        assertThat(result).isNotSameAs(temp);
    }
}