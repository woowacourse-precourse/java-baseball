package baseball.ui;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    @ValueSource(strings = {"123", "111", "222", "333"})
    @ParameterizedTest
    void _1이상_9이하인_세_자리_숫자를_입력받는다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThat(InputView.numbers()).isEqualTo(input);
    }

    @ValueSource(strings = {"12", "012", "1234", "abc", "가나다", "!@#"})
    @ParameterizedTest
    void _1이상_9이하인_세_자리_숫자가_아니면_예외가_발생한다(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(InputView::numbers)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
