package baseball.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    @Test
    void 숫자_입력_묻기() {
        String expectedInputNumber = "123";

        InputStream in = new ByteArrayInputStream(expectedInputNumber.getBytes());
        System.setIn(in);

        String actualInputNumber = InputView.askNumberMessage();

        Assertions.assertThat(actualInputNumber).isEqualTo(expectedInputNumber);
    }


    @Test
    void 재시작_입력_묻기() {
        String expectedInputNumber = "1";

        InputStream in = new ByteArrayInputStream(expectedInputNumber.getBytes());
        System.setIn(in);

        String actualInputNumber = InputView.askRestartMessage();

        Assertions.assertThat(actualInputNumber).isEqualTo(expectedInputNumber);
    }
}
