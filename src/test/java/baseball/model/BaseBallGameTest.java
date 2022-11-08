package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class BaseBallGameTest {
    @Test
    void baseBallHitsTypeMap() {
        BallNumbers hits = new BallNumbers(List.of('1', '3', '4'));
        TestCreateStrategy testCreateStrategy = new TestCreateStrategy();
        List<Character> ballNumbers = testCreateStrategy.createBallNumbers();
        BaseBallGame baseBallGame = new BaseBallGame();
        Map<BaseBallHitsType, Integer> baseBallHitsTypeMap = baseBallGame.baseBallHitsTypeMap(ballNumbers,hits);

        assertAll(() -> assertEquals(baseBallHitsTypeMap.get(BaseBallHitsType.STRIKE), 1),
                () -> assertEquals(baseBallHitsTypeMap.get(BaseBallHitsType.BALL), 1),
                () -> assertEquals(baseBallHitsTypeMap.get(BaseBallHitsType.NOTING), 1));
    }

}
