package baseball.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PlayerTest {
    private Player player;

    @BeforeEach
    void createPlayer(){
        player = new Player();
    }

    @Test
    void 사용자_입력이_숫자가_아닐때(){
        String inputString = "sdf";

        assertThatThrownBy(() -> player.isInt(inputString)).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("숫자만 입력해주세요.");
    }
}
