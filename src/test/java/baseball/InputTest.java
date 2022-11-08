package baseball;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {

    @DisplayName(value = "Numbers, Number 입력 테스트")
    @Test
    void inputValueTest() throws Exception {

        int input = 123;
        int[] inputs = {1,2,3};

        Numbers numbers = Numbers.createNumbers(123);

        for (int index = 0; index < 3; index++) {
            assertThat(numbers.findNumber(index))
                    .isEqualTo(Number.createNumber(inputs[index]));
        }
    }

    @DisplayName(value = "Numbers, Number 입력 예외 테스트")
    @Test
    void inputExceptionTest() throws Exception {

        int input1 = 123;
        // 예외 발생 케이스
        int input2 = 1234;
        int input3 = 12;
        int input4 = 100;
        int input5 = 122;

        assertThat(Numbers.createNumbers(input1))
                .isInstanceOf(Numbers.class);
        // 예외 발생 테스트
        assertThatThrownBy(() -> Number.createNumber(input2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Number.createNumber(input3))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Number.createNumber(input4))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Number.createNumber(input5))
                .isInstanceOf(IllegalArgumentException.class);

    }


}
