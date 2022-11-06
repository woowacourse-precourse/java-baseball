package baseball.answer;

import static org.junit.jupiter.api.Assertions.assertTimeout;

import baseball.gametype.BaseballType;
import org.junit.jupiter.api.Test;
import java.time.Duration;

public class BaseballAnswerTest {

    @Test
    void constructorTest() {
        assertTimeout(Duration.ofMillis(5000), () -> {
            new BaseballAnswer(BaseballType.THREE_DIGITS);
        });
    }
}
