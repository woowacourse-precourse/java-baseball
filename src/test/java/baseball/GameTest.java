package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void getNumInputCase1() {
        List<Integer> nums = new ArrayList<>();
        Game game = new Game();
        game.getNumInput(nums, "413");

        assertThat(nums.size()).isEqualTo(3);
    }

    @Test
    void getNumInputCase2() {
        List<Integer> nums = new ArrayList<>();
        Game game = new Game();

        assertThatThrownBy(() -> game.getNumInput(nums, "112"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getNumInputCase3() {
        List<Integer> nums = new ArrayList<>();
        Game game = new Game();

        assertThatThrownBy(() -> game.getNumInput(nums, "120"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}