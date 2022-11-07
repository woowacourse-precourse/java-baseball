package featuretest;
import baseball.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {

    public Game game;

    @BeforeEach
    public void 멤버_초기화(){
        game = new Game();
    }

    @Test
    void 인풋데이터_예외_체크(){
        assertThrows(IllegalArgumentException.class, () -> {
            game.checkExceptionFromUserInputData("333");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            game.checkExceptionFromUserInputData("abc");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            game.checkExceptionFromUserInputData("1234");
        });
    }
}
