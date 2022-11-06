package baseball.exception;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputExceptionTest {
    @ParameterizedTest
    @ValueSource(strings = {"113", "12", "가13", "ABC", "12354", ""})
    void 입력_에외_테스트(String inputData) {
        List<String> playersNumber = Arrays.asList(inputData.split(""));

        assertThatThrownBy(() -> InputException.checkExceptionNumber(playersNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
