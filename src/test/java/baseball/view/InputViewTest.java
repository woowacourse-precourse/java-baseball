package baseball.view;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    void userBaseballInput_메서드_입력() {
        String input = "456";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(InputView.userBaseballInput()).isEqualTo("456");
    }

    @Test
    void endOrRestartInput_메서드_입력_검증_성공() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(InputView.endOrRestartInput()).isEqualTo(1);
    }

    @Test
    void endOrRestartInput_메서드_입력_길이가_1이_아님() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> InputView.endOrRestartInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 길이가 1이 아닙니다");
    }

    @Test
    void endOrRestartInput_메서드_1_또는_2를_입력하지_않음() {
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> InputView.endOrRestartInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 또는 2를 입력해야 합니다");
    }
}