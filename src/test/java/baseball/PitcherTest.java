package baseball;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class PitcherTest {
    Pitcher p = new Pitcher("713");

    @Test
    void 입력한_수가_투수의_리스트에_분리돼서_저장() {
        List<Integer> expected = List.of(7, 1, 3);

        assertThat(p.getPitcherNumbers()).isEqualTo(expected);
    }

    @Test
    void 입력이_숫자가_아닌_경우() {
        String input = "abc";

        assertThatThrownBy(() -> p.setPitcherNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닙니다. 다시 입력해주세요.");
    }

    @Test
    void 입력의_숫자가_중복될_경우() {
        String input = "114";

        assertThatThrownBy(() -> p.setPitcherNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 중복됩니다. 다시 입력해주세요.");
    }

    @Test
    void 입력된_숫자의_길이가_다를_경우() {
        String input = "1234";
        assertThatThrownBy(() -> p.setPitcherNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3글자로 입력해주세요.");


    }
}