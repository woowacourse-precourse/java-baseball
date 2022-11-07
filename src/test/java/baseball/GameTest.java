package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void getNumInput() {
        List<Integer> nums = new ArrayList<>();
        Game game = new Game();
        game.getNumInput(nums, "413");

        assertThat(nums.size()).isEqualTo(3);
    }
}