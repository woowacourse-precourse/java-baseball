package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    @Test
    void getRandomNumberList_메서드가_1부터_9까지_서로_다른_3개의_수로_이루어진_리스트를_반환하는지_검증() {
        Game game = new Game();
        List<Integer> result = game.getRandomNumberList();

        assertThat(result).hasSize(3);
        for (int number : result) {
            assertThat(number).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(9);
        }
        assertThat(result.get(0)).isNotEqualTo(result.get(1));
        assertThat(result.get(1)).isNotEqualTo(result.get(2));
        assertThat(result.get(2)).isNotEqualTo(result.get(0));
    }

}
