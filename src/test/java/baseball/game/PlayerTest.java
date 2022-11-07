package baseball.game;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    private Player player;

    @BeforeEach
    void initial() {
        player = new Player();
    }

    @Test
    void 사용자_대답_범위_테스트_X() {
        // given
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when, then
        assertThatThrownBy(() -> {
            player.getPlayerAnswer();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
