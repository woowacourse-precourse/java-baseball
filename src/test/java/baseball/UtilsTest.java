package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class UtilsTest {

    @Test
    void 숫자를_분리해_리스트에_저장() {
        List<Integer> test = List.of(1, 2, 3);
        assertThat(Utils.intToList(123)).isEqualTo(test);
    }
}