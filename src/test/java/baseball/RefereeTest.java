package baseball;

import baseball.result.Result;
import baseball.result.Referee;
import baseball.result.ResultType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RefereeTest {

    @Test
    void processResult() {
        // given
        Referee processor = new Referee();
        String randomNumber = "123";
        String predictedNumber = "123";

        // when
        Result result = processor.processResult(randomNumber, predictedNumber);

        // then
        Assertions.assertEquals(result.getResultType(), ResultType.EXACT_MATCH);
    }
}