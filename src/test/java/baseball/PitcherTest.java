package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
class PitcherTest {

    @Test
    void 입력한_수가_투수의_리스트에_분리돼서_저장() {
        List<Integer> expected = List.of(7, 1, 3);
        Pitcher p = new Pitcher("713");

        assertThat(p.getPitcherNumbers()).isEqualTo(expected);
    }
}