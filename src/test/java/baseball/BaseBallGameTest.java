package baseball;

import baseball.Messages.ErrorMessages;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BaseBallGameTest {

    BaseBallGame game = new BaseBallGame();

    @Test
    void 기입을_안하거나_2자리_이상의_수를_기입한_경우() {
        String input = "12";

        assertThatThrownBy(() -> game.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 or 2만 입력해주세요.");
    }

    @Test
    void 기입한_문자열이_숫자가_아닌_경우() {
        String input = "a";

        assertThatThrownBy(() -> game.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닙니다. 다시 입력해주세요.");
    }

    @Test
    void 기입한_숫자가_1_또는_2가_아닌_경우() {
        String input = "3";

        assertThatThrownBy(() -> game.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 or 2만 입력해주세요.");
    }
}