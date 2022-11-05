package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    @Test
    void 숫자가_3개가_아닐_경우_예외_처리_테스트(){
        List<Integer> numbers = List.of(1,2,3,4);

        assertThatThrownBy(() -> new Player(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("numbers size is not 3");
    }

    @Test
    void 숫자에_중복이_있을_경우_예외_처리_테스트(){
        List<Integer> numbers = List.of(1,1,3);

        assertThatThrownBy(() -> new Player(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("duplicates in the numbers");
    }

    @Test
    void 숫자의_범위가_1부터_9사이가_아닐_경우_예외_처리_테스트(){
        List<Integer> numbers = List.of(10,1,3);

        assertThatThrownBy(() -> new Player(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Wrong number range");
    }

    @Test
    void 컴퓨터의_숫자와_같은_숫자를_포함할_때_인덱스_반환_테스트(){
        Player player = new Player(List.of(1,2,3));

        assertEquals(0, player.findIndexOfNumber(1));
    }

    @Test
    void 컴퓨터의_숫자와_같은_숫자를_포함하지_않을_경우_테스트(){
        Player player = new Player(List.of(1,2,3));

        assertEquals(-1, player.findIndexOfNumber(5));
    }
}
