package baseball.logic;

import baseball.domain.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameLogicTest {

    GameLogic gameLogic = new GameLogic();

    @BeforeEach
    void setUp() {
        gameLogic.setUp("369");
    }

    @Test
    void 결과_검증() {
        gameLogic.process("369");

        assertResult( 3, 0);

        gameLogic.process("396");

        assertResult( 1, 2);

        gameLogic.process("123");

        assertResult( 0, 1);

        gameLogic.process("248");

        assertResult( 0, 0);
    }

    private void assertResult( Integer strike, Integer ball) {
        assertThat(Result.getStrike()).isEqualTo(strike);
        assertThat(Result.getBall()).isEqualTo(ball);
    }
}