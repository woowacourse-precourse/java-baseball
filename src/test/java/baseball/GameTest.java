package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;


public class GameTest {
    @DisplayName("컴퓨터의 랜덤 숫자얻기")
    @Test
    void getComputerNumber() {
        Game game = new Game();
        assertThat(game.getComputerNumber()).doesNotContain(0).hasSize(3).doesNotHaveDuplicates();
    }

    @DisplayName("플레이어의 중복된 숫자이면 예외")
    @Test
    void isPlayerNumberDuplicate() {
        Game game = new Game();
        System.setIn(new ByteArrayInputStream("133".getBytes()));

        assertThatThrownBy(() -> game.getPlayerNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어의 3자리가 아닌 숫자이면 예외")
    @Test
    void isPlayerNumberThreeDigits() {
        Game game = new Game();
        System.setIn(new ByteArrayInputStream("1234".getBytes()));

        assertThatThrownBy(() -> game.getPlayerNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

}
