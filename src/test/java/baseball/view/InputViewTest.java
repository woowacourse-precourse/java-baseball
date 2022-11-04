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

    @ParameterizedTest
    @ValueSource(strings = {"A", "b", "♥︎", "F1"})
    void 사용자가_입력한_수_입력_받기_숫자가_아니면_예외_처리(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(InputView::inputNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] : 입력하는 수는 숫자여야합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"102", "012", "910"})
    void 사용자가_입력한_수_입력_받기_0이_포함될_경우_예외_처리(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(InputView::inputNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] : 입력하는 수는 0이 포함될 수 없습니다. 1~9까지의 수를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "112"})
    void 사용자가_입력한_수_입력_받기_서로_다른_수가_아니면_예외_처리(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(InputView::inputNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] : 입력하는 수는 서로 다른 수여야합니다.");
    }
}
