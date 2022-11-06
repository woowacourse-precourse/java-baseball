package baseball.domain.number.inputnumber;

import baseball.domain.inputnumber.InputNumberFactory;
import baseball.domain.inputnumber.InputNumbers;
import baseball.domain.SingleNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputNumbersTest {

    @Test
    void ball이_3일_경우_3을_리턴한다() {
        InputNumbers inputNumbers = InputNumberFactory.newInstance("123");
        List<SingleNumber> randomNumbers = List.of(
                new SingleNumber(0, 3),
                new SingleNumber(1, 1),
                new SingleNumber(2, 2)
        );

        assertThat(inputNumbers.countBall(randomNumbers)).isEqualTo(3);
    }

    @Test
    void ball이_0일_경우_0을_리턴한다() {
        InputNumbers inputNumbers = InputNumberFactory.newInstance("123");
        List<SingleNumber> randomNumbers = List.of(
                new SingleNumber(0, 1),
                new SingleNumber(1, 2),
                new SingleNumber(2, 3)
        );

        assertThat(inputNumbers.countBall(randomNumbers)).isEqualTo(0);
    }

    @Test
    void strike가_3일_경우_3을_리턴한다() {
        InputNumbers inputNumbers = InputNumberFactory.newInstance("123");
        List<SingleNumber> randomNumbers = List.of(
                new SingleNumber(0, 1),
                new SingleNumber(1, 2),
                new SingleNumber(2, 3)
        );

        assertThat(inputNumbers.countStrike(randomNumbers)).isEqualTo(3);
    }

    @Test
    void strike가_0일_경우_0을_리턴한다() {
        InputNumbers inputNumbers = InputNumberFactory.newInstance("123");
        List<SingleNumber> randomNumbers = List.of(
                new SingleNumber(0, 3),
                new SingleNumber(1, 1),
                new SingleNumber(2, 2)
        );

        assertThat(inputNumbers.countStrike(randomNumbers)).isEqualTo(0);
    }
}