package baseball;

import baseball.Player;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
    }

    @Test
    void createPlayerNumbers() {
        List<Integer> playerNumbers = player.createPlayerNumbers("345");
        Assertions.assertThat(playerNumbers).isEqualTo(List.of(3, 4, 5));
    }
}