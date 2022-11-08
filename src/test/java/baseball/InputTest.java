package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest {

    @DisplayName(value = "Numbers, Number 입력 테스트")
    @ParameterizedTest
    @ValueSource(ints = {123})
    void inputValueTest(int input) throws Exception {
        Numbers numbers = Numbers.createNumbers(input);
        int[] inputs = {1,2,3};

        for (int index = 0; index < 3; index++) {
            assertThat(numbers.findNumber(index))
                    .isEqualTo(Number.createNumber(inputs[index]));
        }
    }

    @DisplayName(value = "Numbers, Number 입력 예외 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1234, 12, 100, 122})
    void inputExceptionTest(int input) throws Exception {
        assertThatThrownBy(() -> Numbers.createNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "공백 입력 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {" ","\t", "  "})
    void inputBlankExceptionTest(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> Input.readInt())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
