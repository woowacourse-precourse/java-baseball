package baseball.service;

import org.junit.jupiter.api.Test;

import static baseball.service.Validation.isValidNumber;
import static org.assertj.core.api.Assertions.*;

class ValidationTest {

    @Test
    void 유효하지않은_3자리_숫자가_들어왔을_때_예외_발생() {
        String[] inputs = {"삼사d", "1 2", "343", "1234", "12삼", "", " ", "360"};
        for (String number : inputs) {
            assertThatThrownBy(() -> isValidNumber(number))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 유효한_3자리_숫자가_들어왔을_때_true_리턴() {
        String input = "346";

        boolean flag = isValidNumber(input);

        assertThat(flag).isTrue();
    }
}