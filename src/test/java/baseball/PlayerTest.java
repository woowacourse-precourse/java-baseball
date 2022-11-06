package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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
    void 스트라이크일_때_true_반환_테스트(){
        Player player = new Player(List.of(1,2,3));

        assertTrue(player.isStrike(0, 1));
    }

    @Test
    void 스트라이크가_아닐_때_false_반환_테스트(){
        Player player = new Player(List.of(1,2,3));

        assertFalse(player.isStrike(2, 1));
    }

    @Test
    void 볼일_때_true_반환_테스트(){
        Player player = new Player(List.of(1,2,3));

        assertTrue(player.isBall(1,3));
    }

    @Test
    void 스트라이크여서_볼이_아닐_때_false_반환_테스트(){
        Player player = new Player(List.of(1,2,3));

        assertFalse(player.isBall(0,1));
    }

    @Test
    void 없는_숫자여서_볼이_아닐_때_false_반환_테스트(){
        Player player = new Player(List.of(1,2,3));

        assertFalse(player.isBall(0,9));
    }

    @Test
    void 숫자가_포함될_때_true_반환_테스트(){
        Player player = new Player(List.of(1,2,3));

        assertTrue(player.isContain(2));
    }

    @Test
    void 숫자가_포함되지_않을_때_false_반환_테스트(){
        Player player = new Player(List.of(1,2,3));

        assertFalse(player.isContain(6));
    }
}
