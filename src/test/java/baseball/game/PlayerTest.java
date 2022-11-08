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
    void 사용자의_응답이_재시작_혹은_종료_문자가_아니라면_예외가_발생합니다() {
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> {
            player.getPlayerAnswer();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
