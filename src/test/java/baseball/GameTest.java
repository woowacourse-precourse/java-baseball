package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GameTest {

    Game game = new Game();

    @Test
    void getRandomNumberList_메서드가_1부터_9까지_서로_다른_3개의_수로_이루어진_리스트를_반환하는지_검증() {
        List<Integer> result = game.getRandomNumberList();

        assertThat(result).hasSize(3);
        assertThat(result.get(0)).isNotEqualTo(result.get(1));
        assertThat(result.get(1)).isNotEqualTo(result.get(2));
        assertThat(result.get(2)).isNotEqualTo(result.get(0));
        for (int number : result) {
            assertThat(number).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(9);
        }
    }

    @Test
    void getUserNumberList_메서드가_문자열을_리스트로_변환하는지_검증() {
        String input = "234";
        List<Integer> result = game.getUserNumberList(input);

        assertThat(result).containsExactly(2,3,4);
    }

    @Test
    void validateUserInput_메서드_사용시_숫자_이외의_문자를_입력하면_예외_발생() {
        String input = "abc";

        assertThatThrownBy(() -> game.validateUserInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자 이외의 문자는 입력받지 않습니다.");
    }

    @Test
    void validateUserInput_메서드_사용시_숫자를_3개보다_많게_또는_적게_입력하면_예외_발생() {
        String input = "1";

        assertThatThrownBy(() -> game.validateUserInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자 3개를 입력해야 합니다.");

        String input2 = "1234";

        assertThatThrownBy(() -> game.validateUserInput(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자 3개를 입력해야 합니다.");
    }

    @Test
    void validateUserInput_메서드_사용시_같은_숫자를_두_번_입력하면_예외_발생() {
        String input = "122";

        assertThatThrownBy(() -> game.validateUserInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("서로 다른 숫자 3개를 입력해야 합니다.");
    }

    @Test
    void validateUserExitInput_메서드_사용시_길이가_1을_넘는_문자열을_입력하면_예외_발생() {
        String input = "123";

        assertThatThrownBy(() -> game.validateUserExitInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 또는 2만 입력할 수 있습니다.");
    }

    @Test
    void validateUserExitInput_메서드_사용시_숫자가_아닌_문자를_입력하면_예외_발생() {
        String input = "a";

        assertThatThrownBy(() -> game.validateUserExitInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 또는 2만 입력할 수 있습니다.");
    }

    @Test
    void validateUserExitInput_메서드_사용시_1과_2가_아닌_다른_숫자를_입력하면_예외_발생() {
        String input = "3";

        assertThatThrownBy(() -> game.validateUserExitInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 또는 2만 입력할 수 있습니다.");
    }

}
