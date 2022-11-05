package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class GameTest {
    private static Game game;

    @BeforeAll
    static void initAll() {
        game = new Game();
    }

    @Test
    void inputEndProgramData1() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        game.inputEndProgramData();
        assertThat(game.keepProgram).isEqualTo(true);
    }

    @Test
    void inputEndProgramData2() {
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        game.inputEndProgramData();

        assertThat(game.keepProgram).isEqualTo(false);
    }

    @Test
    void inputEndProgramData3() {
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatIllegalArgumentException().isThrownBy(() -> game.inputEndProgramData());
    }
}