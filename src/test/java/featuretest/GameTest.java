package featuretest;
import baseball.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    void from_스트링_to_리스트(){
        List<Integer> testNumber = List.of(1, 2, 3);
        assertThat(game.makeUserNumberToList("123")).isEqualTo(testNumber);
    }
}
