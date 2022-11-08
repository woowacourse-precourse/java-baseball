package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    void startGame() {
    }

    @Test
    void check_ball_get_ball() throws NoSuchMethodException {
        Game game = new Game();
        // when
        Method initBalls = Game.class.getDeclaredMethod("initBalls");
        initBalls.setAccessible(true);
        //then
        assertThat(game.getBall()).isEqualTo(0);
    }

    @Test
    void check_ball_get_strike() throws NoSuchMethodException {
        Game game = new Game();
        // when
        Method initBalls = Game.class.getDeclaredMethod("initBalls");
        initBalls.setAccessible(true);
        //then
        assertThat(game.getStrike()).isEqualTo(0);
    }
}