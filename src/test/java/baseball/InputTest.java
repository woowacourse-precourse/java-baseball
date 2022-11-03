package baseball;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {

    @Test
    void inputValueTest() throws Exception {

        int input = 123;
        int[] inputs = {1,2,3};

        Numbers numbers = new Numbers(123);

        for (int index = 0; index < 3; index++) {
            assertThat(numbers.findNumber(index))
                    .isEqualTo(new Number(inputs[index]));
        }
    }


    @Test
    void inputExceptionTest() throws Exception {

        int input1 = 123;
        // 예외 발생 케이스
        int input2 = 1234;
        int input3 = 12;
        int input4 = 100;

        assertThat(new Numbers(input1))
                .isInstanceOf(Numbers.class);
        // 예외 발생 테스트
        assertThatThrownBy(() -> new Numbers(input2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Numbers(input3))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Numbers(input4))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
