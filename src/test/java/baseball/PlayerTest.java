package baseball;

import baseball.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @Test
    void 입력받은_문자열을_정수_리스트로_저장한다() {
        player.setNumbers("123");

        assertEquals(player.getNumbers(), Arrays.asList(1, 2, 3));
    }
}
