package baseball.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    @Test
    void 숫자_아닌_것_포함_입력_예외_던지기() {
        assertThatThrownBy(() -> {
            InputView.input("1w3");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
