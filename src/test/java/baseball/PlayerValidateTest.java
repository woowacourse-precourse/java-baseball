package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PlayerValidateTest {

    @Test
    void 플레이어의_범위_내_숫자가_아닌_경우_예외발생() {
        Player test = new Player();

        String input1 = "0";

        assertThatThrownBy(() -> test.validateInputRangeNumber(Integer.parseInt(input1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 1 ~ 9 사이의 값이어야 합니다.");
    }

    @Test
    void 플레이어의_숫자_중복_발생_시_예외발생() {
        Player test = new Player();

        String input1 = "121";

        assertThatThrownBy(() -> test.validateDuplicateInput(Integer.parseInt(input1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 1 ~ 9 사이의 값이어야 합니다.");
    }

    @Test
    void 플레이어의_글자_길이가_3이_아닌_경우_예외발생() {
        Player test = new Player();

        String input1 = "12";
        String input2 = "1234";

        assertThatThrownBy(() -> test.validateInputLength(input1.length(), 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 3 자여야 합니다.");

        assertThatThrownBy(() -> test.validateInputLength(input2.length(), 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 3 자여야 합니다.");
    }

    @Test
    void 게임_종료_시_플레이어_입력_값의_길이가_1이_아닌_경우_예외발생() {
        Player test = new Player();

        String input1 = "123";
        String input2 = "1234";

        assertThatThrownBy(() -> test.validateInputLength(input1.length(), 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 1 자여야 합니다.");

        assertThatThrownBy(() -> test.validateInputLength(input2.length(), 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 1 자여야 합니다.");
    }

    @Test
    void 게임_종료_시_플레이어_1_또는_2가_아닌_경우_예외발생() {
        Player test = new Player();

        String input1 = "3";
        String input2 = "5";

        assertThatThrownBy(() -> test.validateGameOverInput(Integer.parseInt(input1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 1 또는 2 의 값이어야 합니다.");

        assertThatThrownBy(() -> test.validateGameOverInput(Integer.parseInt(input1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 1 또는 2 의 값이어야 합니다.");
    }
}
