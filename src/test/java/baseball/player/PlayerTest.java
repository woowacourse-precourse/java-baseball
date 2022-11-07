package baseball.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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

    @Test
    void 사용자_입력이_리스트로_변환되는지(){
        String inputString = "123";
        List<Integer> list = List.of(1,2,3);

        assertThat(player.changeInputToList(inputString)).isEqualTo(list);
    }
}
