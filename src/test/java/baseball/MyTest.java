package baseball;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MyTest {

    @Test
    void 게임초기화_난수_생성() {
        // given
        GameContext gameCtx = new GameContext();
        // when
        gameCtx.initializeContext();
        Integer answer = Integer.parseInt(gameCtx.getAnswer());
        // then
        assertThat(answer).isGreaterThanOrEqualTo(111);
        assertThat(answer).isLessThanOrEqualTo(999);
        assertThat(gameCtx.getState()).isEqualTo(GameState.RUNNING);
    }
}
