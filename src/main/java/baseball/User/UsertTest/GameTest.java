package baseball.User.UsertTest;

import baseball.User.Game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class GameTest {
    @Test
    @DisplayName("잘못된 입력값 테스트")
    void GameTest() {

        Game game = new Game();
        int put = 3;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> game.startGame());


        assertThat(exception.getMessage()).isEqualTo("");


    }
}