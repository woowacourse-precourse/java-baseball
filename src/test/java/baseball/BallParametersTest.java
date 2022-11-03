package baseball;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class BallParametersTest {
    @ParameterizedTest
    @ValueSource(strings = {"3214", "332","33","","78 "})
    void if_duplicate_consecutive_num(String hits) {
        assertThrows(IllegalArgumentException.class, () -> new BallParameters(hits));
    }
}
