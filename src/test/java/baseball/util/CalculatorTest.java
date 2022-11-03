package baseball.util;

import baseball.model.Score;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

    @Test
    void 숫자_계산기_테스트() {
        Score score = Calculator.score("423", "456");
        assertEquals(1, score.getStrike());
        assertEquals(0, score.getBall());
    }

}