package baseball.domain.count.strike;

import baseball.domain.number.SingleNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StrikeCounterTest {

    private final StrikeCounter strikeCounter = new StrikeCounter();

    @Test
    void strike가_3개인_경우() {
        List<SingleNumber> randomNumbers = List.of(
                new SingleNumber(0, 1),
                new SingleNumber(1, 2),
                new SingleNumber(2, 3)
        );

        List<SingleNumber> inputNumbers = List.of(
                new SingleNumber(0, 1),
                new SingleNumber(1, 2),
                new SingleNumber(2, 3)
        );

        StrikeResult strikeResult = strikeCounter.checkStrike(randomNumbers, inputNumbers);
        assertThat(strikeResult.strikeCount()).isEqualTo(3);
    }

    @Test
    void strike가_0개인_경우() {
        List<SingleNumber> randomNumbers = List.of(
                new SingleNumber(0, 1),
                new SingleNumber(1, 2),
                new SingleNumber(2, 3)
        );

        List<SingleNumber> inputNumbers = List.of(
                new SingleNumber(0, 3),
                new SingleNumber(1, 1),
                new SingleNumber(2, 2)
        );

        StrikeResult strikeResult = strikeCounter.checkStrike(randomNumbers, inputNumbers);
        assertThat(strikeResult.strikeCount()).isEqualTo(0);
    }
}