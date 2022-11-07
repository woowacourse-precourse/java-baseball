package baseball.utils;

import baseball.domain.Score;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameScoreCounterTest {

    @Test
    void 숫자_계산기_테스트() {
        Score score = BaseballGameScoreCounter.checkScore("423", "456");
        assertAll(
                () -> assertEquals(1, score.getStrike()),
                () -> assertEquals(0, score.getBall())
        );
    }
}