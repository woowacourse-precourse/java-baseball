package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BaseballGameTest {

    BaseballGame game;

    @BeforeEach
    public void beforeEach() {
        game = new BaseballGame();
    }

    @Test
    void create_computer_number() {
        List<Integer> computer = game.pickTargetNumber();
        Set<Integer> numberSet = new HashSet<>(computer);
        assertThat(computer.size()).isEqualTo(numberSet.size());
    }

    @Test
    void check_user_number_test() {
        assertThat(game.checkUserNumber("123")).isEqualTo(List.of(1, 2, 3));
        assertThat(game.checkUserNumber("359")).isEqualTo(List.of(3, 5, 9));
        assertThatThrownBy(() -> game.checkUserNumber("3456"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> game.checkUserNumber("61"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> game.checkUserNumber("ab2"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> game.checkUserNumber("224"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> game.checkUserNumber("204"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
