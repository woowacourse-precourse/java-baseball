package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;


class PitcherTest {

    private final Pitcher pitcher = new Pitcher();

    @Test
    public void input이_다른문자로만_이루어져있는지_확인() {
        String input = "112";

        assertThatThrownBy(() -> pitcher.validateInputUnique(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력중 같은 문자가 있습니다.");
    }

    @Test
    public void input이_숫자로만_이루어져있는지_확인() {
        String input = "1ab";

        assertThatThrownBy(() -> pitcher.validateInputType(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바르지 않은 입력이 있습니다.");
    }

    @Test
    public void input이_3개인지_확인() {
        String input = "12";

        assertThatThrownBy(() -> pitcher.validateInputSize(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 갯수가 틀립니다.");
    }

    @Test
    public void number필드가_3개의_수를_가지는지_확인() {
        String input = "123";
        pitcher.setNumber(input);

        assertThat(pitcher.getNumber()).hasSize(3);
    }

    @Test
    public void number필드와_input이_같은값을_가지는지_확인() {
        String input = "123";
        pitcher.setNumber(input);

        Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .forEach(number -> assertThat(pitcher.getNumber()).contains(number));
    }

}