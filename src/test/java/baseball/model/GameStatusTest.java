package baseball.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameStatusTest {

    @Test
    void 게임_상태_반환_테스트(String input) {
        Assertions.assertEquals(GameStatus.GAME_OVER, GameStatus.fromIsThreeStrike(true));
    }
}
