package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class BaseBallResultTest {
    @Test
    void if_nothing_() {
        BaseBallResult baseBallResult = new BaseBallResult();

        Map<BaseBallHitsType, Integer> result = new HashMap<>();
        result.put(BaseBallHitsType.STRIKE, 0);
        result.put(BaseBallHitsType.BALL, 0);
        result.put(BaseBallHitsType.NOTING, 3);

        assertEquals(baseBallResult.result(result),BaseBallHitsType.NOTING.getBallResultType());
    }

    @Test
    void if_not_noting() {
        BaseBallResult baseBallResult = new BaseBallResult();

        Map<BaseBallHitsType, Integer> result = new HashMap<>();
        result.put(BaseBallHitsType.STRIKE, 1);
        result.put(BaseBallHitsType.BALL, 1);
        result.put(BaseBallHitsType.NOTING, 0);

        assertEquals(baseBallResult.result(result),"1볼 1스트라이크 ");
    }
    @Test
    void just_strike() {
        BaseBallResult baseBallResult = new BaseBallResult();

        Map<BaseBallHitsType, Integer> result = new HashMap<>();
        result.put(BaseBallHitsType.STRIKE, 1);
        result.put(BaseBallHitsType.BALL, 0);
        result.put(BaseBallHitsType.NOTING, 0);

        assertEquals(baseBallResult.result(result),"1스트라이크 ");
    }

    @Test
    void just_ball() {
        BaseBallResult baseBallResult = new BaseBallResult();

        Map<BaseBallHitsType, Integer> result = new HashMap<>();
        result.put(BaseBallHitsType.STRIKE, 0);
        result.put(BaseBallHitsType.BALL, 1);
        result.put(BaseBallHitsType.NOTING, 0);

        assertEquals(baseBallResult.result(result),"1볼 ");
    }
}
