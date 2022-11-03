package baseball;

import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberTest {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;
    private static final int CNT_NUMBER = 3;

    Number number;

    @BeforeEach
    void createNumber() {
        number = new Number();
    }

    @Test
    void 컴퓨터_숫자_갯수_검증() {
        List<Integer> computerNumbers = number.generateRandomNumber();
        int computerNumbersSize = computerNumbers.size();
        Assertions.assertThat(computerNumbersSize).isEqualTo(CNT_NUMBER);
    }

    @Test
    void 컴퓨터_숫자_범위_검증() {
        List<Integer> computerNumbers = number.generateRandomNumber();
        boolean computerNumbersRange = computerNumbers.stream().allMatch(num -> num >= MIN_RANGE && num <= MAX_RANGE);
        Assertions.assertThat(computerNumbersRange).isTrue();
    }

    @Test
    void 컴퓨터_숫자_중복_검사() {
        List<Integer> computerNumbers = number.generateRandomNumber();
        int uniqueComputerNumbers = computerNumbers.stream().distinct().collect(Collectors.toList()).size();
        Assertions.assertThat(uniqueComputerNumbers).isEqualTo(3);
    }
}