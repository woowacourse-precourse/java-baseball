package baseball;

import org.assertj.core.error.ShouldNotHaveDuplicates;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.IllegalFormatException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
class PitcherTest {
    Pitcher p;

    @Test
    void 입력한_수가_투수의_리스트에_분리돼서_저장() {
        List<Integer> expected = List.of(7, 1, 3);
        Pitcher p = new Pitcher("713");

        assertThat(p.getPitcherNumbers()).isEqualTo(expected);
    }

    @Test
    void 입력이_숫자가_아닌_경우() {
        String input = "abc";

        assertThatThrownBy(() -> p.setPitcherNumbers(input))
                .isInstanceOf(IllegalFormatException.class)
                .hasMessageContaining("숫자 형식으로 입력해주세요");
    }

    @Test
    void 입력의_숫자가_중복될_경우() {
        String input = "111";

        assertThatThrownBy(() -> p.setPitcherNumbers(input))
                .isInstanceOf(ShouldNotHaveDuplicates.class)
                .hasMessageContaining("중복되지 않는 수를 입력해주세요");
    }

    @Test
    void 입력된_숫자의_길이가_다를_경우() {
        String input = "1234";
        assertThatThrownBy(() -> p.setPitcherNumbers(input))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("3자리 수로 입력해주세요");


    }
}