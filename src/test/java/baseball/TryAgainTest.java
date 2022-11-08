package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TryAgainTest {
    TryAgain tryAgain;

    @Test
    void tryAgainOrWhatTest() {
        tryAgain = new TryAgain();
        String input = "123";

        assertEquals(true, tryAgain.tryAgainOrWhat(input));
    }
}
