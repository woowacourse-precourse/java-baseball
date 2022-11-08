package baseball;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class GameTest {
    @Test
    public void strikeCase1(){
        List<Integer> input = List.of(2, 3, 4);
        List<Integer> computer = List.of(2, 1, 5);
        assertThat(Game.strike(input, computer)).isEqualTo(1);
    }

    @Test
    public void strikeCase2(){
        List<Integer> input = List.of(1, 3, 4);
        List<Integer> computer = List.of(1, 3, 4);
        assertThat(Game.strike(input, computer)).isEqualTo(3);
    }
    @Test
    public void ballCase1(){
        List<Integer> input = List.of(3, 2, 4);
        List<Integer> computer = List.of(1, 5, 4);
        assertThat(Game.ball(input, computer)).isEqualTo(0);
    }

    @Test
    public void ballCase2(){
        List<Integer> input = List.of(1, 2, 3);
        List<Integer> computer = List.of(2, 1, 3);
        assertThat(Game.ball(input, computer)).isEqualTo(2);
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
