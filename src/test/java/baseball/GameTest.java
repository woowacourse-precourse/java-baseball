package baseball;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class GameTest {
    @Test
    public void strike(){
        List<Integer> input = List.of(2, 3, 4);
        List<Integer> computer = List.of(2, 1, 5);
        assertThat(Game.strike(input, computer)).isEqualTo(1);
    }

    @Test
    public void ball(){
        List<Integer> input = List.of(3, 2, 4);
        List<Integer> computer = List.of(1, 5, 4);
        assertThat(Game.strike(input, computer)).isEqualTo(1);
    }

    @Test
    public void nothing(){
        List<Integer> input = List.of(3, 2, 8);
        List<Integer> computer = List.of(1, 5, 4);

        int strikeCounter = Game.strike(input,computer);
        int ballCounter = Game.ball(input, computer);

        boolean result = true;
        assertThat(Game.nothing(strikeCounter, ballCounter)).isEqualTo(result);
    }
}
