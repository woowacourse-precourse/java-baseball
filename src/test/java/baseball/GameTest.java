package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    @Test
    void restart_확인_1() {
        Game game = Game.start(new User());
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        assertThat(game.restart()).isTrue();
    }

    @Test
    void restart_확인_2() {
        Game game = Game.start(new User());
        System.setIn(new ByteArrayInputStream("2".getBytes()));
        assertThat(game.restart()).isFalse();
    }

    @Test
    void restart_실패_1() {
        Game game = Game.start(new User());
        System.setIn(new ByteArrayInputStream("20".getBytes()));
        Exception exception = assertThrows(IllegalArgumentException.class, game::restart);
        assertThat(exception != null).isTrue();
    }

    @Test
    void restart_실패_2() {
        Game game = Game.start(new User());
        System.setIn(new ByteArrayInputStream("restart".getBytes()));
        Exception exception = assertThrows(IllegalArgumentException.class, game::restart);
        assertThat(exception != null).isTrue();
    }
}
