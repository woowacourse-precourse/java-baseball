package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

}
