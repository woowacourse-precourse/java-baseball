package baseball;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {
    @Test
    void testToString_Empty() {
        Map<ThrowingType, Long> scoreTable = Collections.emptyMap();
        Score score = new Score(scoreTable);

        assertTrue(score.allMatch());
        assertEquals(score.toString(), "낫싱");
    }

    @Test
    void testToString_OneBall() {
        Map<ThrowingType, Long> scoreTable = Map.ofEntries(
                Map.entry(ThrowingType.BALL, 1L)
        );
        Score score = new Score(scoreTable);

        assertFalse(score.allMatch());
        assertEquals(score.toString(), "1볼");
    }

    @Test
    void testToString_OneStrike() {
        Map<ThrowingType, Long> scoreTable = Map.ofEntries(
                Map.entry(ThrowingType.STRIKE, 1L)
        );
        Score score = new Score(scoreTable);

        assertTrue(score.allMatch());
        assertEquals(score.toString(), "1스트라이크");
    }

    @Test
    void testToString_TwoBallOneStrike() {
        Map<ThrowingType, Long> scoreTable = Map.ofEntries(
                Map.entry(ThrowingType.STRIKE, 1L),
                Map.entry(ThrowingType.BALL, 2L)
        );
        Score score = new Score(scoreTable);

        assertFalse(score.allMatch());
        assertEquals(score.toString(), "2볼 1스트라이크");
    }

    @Test
    void testToString_ThreeNothing() {
        Map<ThrowingType, Long> scoreTable = Map.ofEntries(
                Map.entry(ThrowingType.NOTHING, 3L)
        );
        Score score = new Score(scoreTable);

        assertFalse(score.allMatch());
        assertEquals(score.toString(), "낫싱");
    }
}