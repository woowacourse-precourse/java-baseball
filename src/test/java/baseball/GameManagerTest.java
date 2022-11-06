package baseball;

import baseball.game.GameManager;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameManagerTest {

    @Test
    void checkRestartGame_return_True_Test() {

        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThat(GameManager.checkRestartGame()).isEqualTo(true);
    }

    @Test
    void checkRestartGame_return_false_Test() {

        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThat(GameManager.checkRestartGame()).isEqualTo(false);
    }

    @Test
    void checkRestartGame_Exception_Test() {

        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assertions.assertThatThrownBy(() -> GameManager.checkRestartGame())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 또는 2만 입력할 수 있습니다.");
    }
}
