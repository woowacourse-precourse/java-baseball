package baseball.logic;

import baseball.domain.Result;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class GameLogicTest {

    GameLogic gameLogic = new GameLogic();

    @BeforeEach
    void setUp() {
        gameLogic.setUp("369");
    }

    @Test
    void 결과_검증() {
        Result result = new Result(-1, -1);
        gameLogic.process("369", result);

        assertResult(result, 3, 0);

        gameLogic.process("396", result);

        assertResult(result, 1, 2);

        gameLogic.process("123", result);

        assertResult(result, 0, 1);

        gameLogic.process("248", result);

        assertResult(result, 0, 0);
    }

    private void assertResult(Result result, Integer strike, Integer ball) {
        assertThat(result.getStrike()).isEqualTo(strike);
        assertThat(result.getBall()).isEqualTo(ball);
    }
}