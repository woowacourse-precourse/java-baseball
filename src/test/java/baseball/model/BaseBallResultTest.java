package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class BaseBallResultTest {
    @Test
    void if_nothing_() {
        Map<BaseBallHitsType, Integer> result = new HashMap<>();
        result.put(BaseBallHitsType.STRIKE, 0);
        result.put(BaseBallHitsType.BALL, 0);
        result.put(BaseBallHitsType.NOTING, 3);

        assertEquals(BaseBallResult.hitResult(result),BaseBallHitsType.NOTING.hitType());
    }

    @Test
    void if_not_noting() {
        Map<BaseBallHitsType, Integer> result = new HashMap<>();
        result.put(BaseBallHitsType.STRIKE, 1);
        result.put(BaseBallHitsType.BALL, 1);
        result.put(BaseBallHitsType.NOTING, 0);

        assertEquals(BaseBallResult.hitResult(result),"1볼 1스트라이크 ");
    }
    @Test
    void just_strike() {
        Map<BaseBallHitsType, Integer> result = new HashMap<>();
        result.put(BaseBallHitsType.STRIKE, 1);
        result.put(BaseBallHitsType.BALL, 0);
        result.put(BaseBallHitsType.NOTING, 0);

        assertEquals(BaseBallResult.hitResult(result),"1스트라이크 ");
    }

    @Test
    void just_ball() {
        Map<BaseBallHitsType, Integer> result = new HashMap<>();
        result.put(BaseBallHitsType.STRIKE, 0);
        result.put(BaseBallHitsType.BALL, 1);
        result.put(BaseBallHitsType.NOTING, 0);

        assertEquals(BaseBallResult.hitResult(result),"1볼 ");
    }

    @Test
    void end() {
        Map<BaseBallHitsType, Integer> result = new HashMap<>();
        result.put(BaseBallHitsType.STRIKE, 3);
        result.put(BaseBallHitsType.BALL, 0);
        result.put(BaseBallHitsType.NOTING, 0);

        assertTrue(BaseBallResult.end(result));
    }

    @Test
    void not_end() {
        Map<BaseBallHitsType, Integer> result = new HashMap<>();
        result.put(BaseBallHitsType.STRIKE, 2);
        result.put(BaseBallHitsType.BALL, 1);
        result.put(BaseBallHitsType.NOTING, 0);

        assertFalse(BaseBallResult.end(result));
    }
}
