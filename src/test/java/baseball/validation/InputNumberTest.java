package baseball.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputNumberTest {

    InputNumber inputNumber = new InputNumber();
    @Test
    void 길이가_3이상인_경우() {
        String input = "1234";
        Assertions.assertThatThrownBy(() -> inputNumber.inputNumberValidate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자_포함() {
        String input = "12r";
        Assertions.assertThatThrownBy(() -> inputNumber.inputNumberValidate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_값_입력() {
        String input = "112";
        Assertions.assertThatThrownBy(() -> inputNumber.inputNumberValidate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}