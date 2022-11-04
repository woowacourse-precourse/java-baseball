package baseball.count.strike;

import baseball.domain.count.strike.StrikeCounter;
import baseball.domain.count.strike.StrikeResult;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StrikeCounterTest {

    private final StrikeCounter strikeCounter = new StrikeCounter();

    @Test
    void strike가_3개인_경우() {
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> inputNumber = List.of(1, 2, 3);
        StrikeResult strikeResult = strikeCounter.checkStrike(answer, inputNumber);

        assertThat(strikeResult.strikeCount()).isEqualTo(3);
    }

    @Test
    void strike가_0개인_경우() {
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> inputNumber = List.of(3, 1, 4);
        StrikeResult strikeResult = strikeCounter.checkStrike(answer, inputNumber);

        assertThat(strikeResult.strikeCount()).isEqualTo(0);
    }
}