package baseball.util;

import baseball.model.Score;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallGameScoreCounterTest {

    @Test
    void 숫자_계산기_테스트() {
        Score score = BaseBallGameScoreCounter.checkScore("423", "456");
        assertAll(
                () -> assertEquals(1, score.getStrike()),
                () -> assertEquals(0, score.getBall())
        );
    }

    @Test
    void 숫자_계산기_테스트_실패() {
        Score score = BaseBallGameScoreCounter.checkScore("123", "321");

        assertAll(
                () -> assertNotEquals(2, score.getStrike()),
                () -> assertNotEquals(1, score.getBall())
        );
    }

}