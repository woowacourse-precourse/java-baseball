package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NumberValidatorTest {

    @Test
    void 사용자가_세자리수_이상을_입력했을_경우() {
        String input = "1234";

        assertThatThrownBy(() -> NumberValidator.checkInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자가_세자리수_미만을_입력했을_경우() {
        String input = "12";

        assertThatThrownBy(() -> NumberValidator.checkInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자가_숫자가_아닌_문자열을_입력했을_경우() {
        String input = "!@%";

        assertThatThrownBy(() -> NumberValidator.checkInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자가_입력한_수에_0이_포함되는_경우() {
        String input = "102";

        assertThatThrownBy(() -> NumberValidator.checkInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자가_중복되는_수를_입력했을_경우() {
        String input = "112";

        assertThatThrownBy(() -> NumberValidator.checkInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사용자가_1이나_2가_아닌_수를_입력했을_경우() {
        String input = "3";

        assertThatThrownBy(() -> NumberValidator.checkReplayInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
