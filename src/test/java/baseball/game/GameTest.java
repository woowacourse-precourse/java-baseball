package baseball.game;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class GameTest {
    private Game game;

    @Test
    void 재시작_입력받은_경우() {
        game = new Game();
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(game.restartOrEnd()).isEqualTo(false);
    }

    @Test
    void 값1_2외를_입력받은_경우() {
        game = new Game();
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> game.restartOrEnd()).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("1,2 중 하나만 입력하세요.");
    }
}
