package baseball;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameTest {

    @Test
    void create_computer_number() {
        BaseballGame game = new BaseballGame();
        List<Integer> computer = game.pickTargetNumber();
        Set<Integer> numberSet = new HashSet<>(computer);
        assertThat(computer.size()).isEqualTo(numberSet.size());
    }
}
