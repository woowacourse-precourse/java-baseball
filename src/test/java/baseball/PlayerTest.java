package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    public void 사용자_입력이_숫자가_아닌_경우_예외처리() {
        String input = "new";
        Player player = new Player();

        assertThatThrownBy(() -> player.inputValidationCheck(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력 가능합니다");
    }

    @Test
    public void 사용자_입력이_3자리가_아닌_경우_예외처리() {
        String input = "123456";
        Player player = new Player();

        assertThatThrownBy(() -> player.inputValidationCheck(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리만 입력 가능합니다");
    }

    @Test
    public void 사용자_입력이_빈값_경우_예외처리() {
        String input = "123456";
        Player player = new Player();

        assertThatThrownBy(() -> player.inputValidationCheck(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리만 입력 가능합니다");
    }

}