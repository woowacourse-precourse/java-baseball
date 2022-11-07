package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ValidCheckTest {

    @Test
    void numberCheck() {
        String testCase = "476aa";
        assertThatThrownBy(() -> ValidCheck.numberCheck(testCase))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력하세요!");

    }

    @Test
    void validInputNumber() {
        List<Integer> testCase1 = new ArrayList<Integer>(Arrays.asList(2, 4));
        List<Integer> testCase2 = new ArrayList<Integer>(Arrays.asList(2, 0, 5));
        List<Integer> testCase3 = new ArrayList<Integer>(Arrays.asList(2, 4, 2));

        assertThatThrownBy(() -> ValidCheck.validInputNumber(testCase1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3자리 숫자를 입력하십시오");

        assertThatThrownBy(() -> ValidCheck.validInputNumber(testCase2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0은 포함 되면 안됩니다");

        assertThatThrownBy(() -> ValidCheck.validInputNumber(testCase3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자가 있습니다");
    }

    @Test
    void isContinueGame() {

    }
}