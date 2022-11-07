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

    @Test
    void 영제외_세자리_중복제외_숫자_확인() {
        String[] testFalse = {"1234", "ㅇㅇㅇ", "122", "1223", "120"};
        String[] testTrue = {"123", "915"};

        for (String test : testFalse) {
            assertThat(Utils.isValidUserAnswerInput(test)).isEqualTo(false);
        }

        for (String test : testTrue) {
            assertThat(Utils.isValidUserAnswerInput(test)).isEqualTo(true);
        }
    }
}