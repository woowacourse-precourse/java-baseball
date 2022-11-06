package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {
    @Test
    void checkNumbers_LongLength_ExpectationThrown() {
        Player player = new Player();
        ArrayList<Integer> input = new ArrayList<Integer>(List.of(1, 2, 3, 4));
        assertThatThrownBy(() -> player.checkNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkNumbers_ShortLength_ExpectationThrown() {
        Player player = new Player();
        ArrayList<Integer> input = new ArrayList<Integer>(List.of(1, 2));
        assertThatThrownBy(() -> player.checkNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkNumbers_DuplicatedNumbers_ExpectationThrown() {
        Player player = new Player();
        ArrayList<Integer> input = new ArrayList<Integer>(List.of(1, 2, 1));
        assertThatThrownBy(() -> player.checkNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkNumbers_WrongRangeOfNumber_ExpectationThrown() {
        Player player = new Player();
        ArrayList<Integer> input = new ArrayList<Integer>(List.of(1, 2, 0));
        assertThatThrownBy(() -> player.checkNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkNumbers_CorrectInput_True() {
        Player player = new Player();
        ArrayList<Integer> input = new ArrayList<Integer>(List.of(1, 2, 3));
        boolean result = false;
        result = player.checkNumbers(input);
        assertThat(result).isEqualTo(true);
    }


}
