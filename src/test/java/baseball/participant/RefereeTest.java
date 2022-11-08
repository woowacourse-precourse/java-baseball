package baseball.participant;

import baseball.result.Result;
import baseball.participant.Referee;
import baseball.result.ResultType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RefereeTest {

    @Test
    void processResult() {
        // given
        Referee referee = new Referee();
        String randomNumber = "123";
        String predictedNumber = "123";

        // when
        Result result = referee.judgeHitAndPitch(randomNumber, predictedNumber);

        // then
        Assertions.assertEquals(result.getResultType(), ResultType.EXACT_MATCH);
    }

    @Test
    void validatePrediction() {
        // given
        Referee referee = new Referee();
        List<String> goodInputs = List.of("123", "456", "789");
        List<String> badInputs = List.of("", "1234", "112", "12", "012", "zero");

        // then
        for (String goodInput : goodInputs)
            assertDoesNotThrow(() -> referee.validateBalk(goodInput));

        for (String badInput : badInputs)
            assertThrows(IllegalArgumentException.class, () -> referee.validateBalk(badInput));
    }

    @Test
    void validateReplaySelection() {
        // given
        Referee referee = new Referee();

        // then
        assertDoesNotThrow(() -> referee.validateReplaySelection("1"));
        assertDoesNotThrow(() -> referee.validateReplaySelection("2"));
        assertThrows(IllegalArgumentException.class, () -> referee.validateReplaySelection("3"));
    }
}