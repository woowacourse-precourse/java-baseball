package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidatorTest {

    @Test
    void validatePrediction() {
        // given
        Validator validator = new Validator();
        List<String> goodInputs = List.of("123", "456", "789");
        List<String> badInputs = List.of("", "1234", "112", "12", "012", "zero");

        // then
        for (String goodInput : goodInputs)
            assertDoesNotThrow(() -> validator.validatePrediction(goodInput));

        for (String badInput : badInputs)
            assertThrows(IllegalArgumentException.class, () -> validator.validatePrediction(badInput));
    }
}