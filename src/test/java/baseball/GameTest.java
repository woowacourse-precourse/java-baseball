package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class GameTest {
    @DisplayName("컴퓨터의 랜덤 숫자얻기")
    @Test
    void getComputerNumber() {
        Game game = new Game();
        assertThat(game.getComputerNumber()).doesNotContain(0).hasSize(3).doesNotHaveDuplicates();
    }
}
