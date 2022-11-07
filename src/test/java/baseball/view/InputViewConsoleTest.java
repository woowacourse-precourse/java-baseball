package baseball.view;

import java.io.ByteArrayInputStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputViewConsoleTest {
    private static final String RESTART_CODE = "1";
    private static final String END_CODE = "2";

    @Test
    void getRestartOrEndCodeTest_예외입력() {
        InputViewConsole iv = new InputViewConsole();
        ByteArrayInputStream is = new ByteArrayInputStream("test".getBytes());
        System.setIn(is);
        Assertions.assertThatThrownBy(iv::askRestart)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getRestartOrEndCodeTest_정상입력() {
        InputViewConsole iv = new InputViewConsole();

        ByteArrayInputStream is = new ByteArrayInputStream(RESTART_CODE.getBytes());
        System.setIn(is);

        Assertions.assertThat(iv.askRestart()).isEqualTo(RESTART_CODE);

        is = new ByteArrayInputStream(END_CODE.getBytes());
        System.setIn(is);

        Assertions.assertThat(iv.askRestart()).isEqualTo(END_CODE);
    }
}