package baseball.model;

import baseball.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
class PlayerTest {

    Player player;

    @BeforeEach
    void initializePlayer(){
        player = new Player();
    }

    @Test
    void 입력이_리스트로_저장된다(){
        player.setNumbers("123");
        assertThat(player.getNumbers()).isEqualTo(List.of(1, 2, 3));
    }
}
