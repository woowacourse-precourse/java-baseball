package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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