package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    private InputStream generateInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    private void generatePlayerInput(String input) {
        System.setIn(generateInputStream(input));
    }

    @DisplayName("숫자를 입력하지 않으면 예외를 발생시킨다")
    @ParameterizedTest
    @ValueSource(strings = "12a")
    void inputNumberExTest(String input) {
        generatePlayerInput(input);

        assertThatThrownBy(() -> InputView.inputNumber())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자가 아닙니다.");
    }

    @DisplayName("숫자를 정상 입력한다")
    @ParameterizedTest
    @ValueSource(strings = "12")
    void inputNumberTest(String input) {
        generatePlayerInput(input);

        String actualInput = InputView.inputNumber();

        assertThat(actualInput).isEqualTo(input);
    }
}