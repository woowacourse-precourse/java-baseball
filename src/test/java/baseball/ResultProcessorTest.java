package baseball;

import baseball.result.Result;
import baseball.result.ResultProcessor;
import baseball.result.ResultType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ResultProcessorTest {

    @Test
    void processResult() {
        // given
        ResultProcessor processor = new ResultProcessor();
        String randomNumber = "123";
        String predictedNumber = "123";

        // when
        Result result = processor.processResult(randomNumber, predictedNumber);

        // then
        Assertions.assertEquals(result.getResultType(), ResultType.EXACT_MATCH);
    }
}