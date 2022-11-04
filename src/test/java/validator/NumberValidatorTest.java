package validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class NumberValidatorTest {

    @Test
    void 숫자_크기가_다른_경우_예외_발생(){
        String checkNumber = "1234";

        assertThatThrownBy(() -> NumberValidator.validate(checkNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 숫자의 크기(길이)를 확인하세요.");
    }

}