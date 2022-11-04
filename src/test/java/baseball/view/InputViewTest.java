package baseball.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"234"})
    void 사용자가_입력한_수_입력_받기(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String playerInputNumber = InputView.inputNumber();
        assertThat(playerInputNumber).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"23", "1", "2345", "12345235"})
    void 사용자가_입력한_수_입력_받기_3자리가_아니면_예외_처리(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(InputView::inputNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] : 입력하는 수는 3자리여야합니다.");
    }
}
