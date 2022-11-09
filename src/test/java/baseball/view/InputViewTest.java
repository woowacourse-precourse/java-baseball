package baseball.view;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    private static ByteArrayOutputStream outputMessage;

    @Test
    void 숫자_입력_묻기() {
        String expectedInputNumber = "123";

        InputStream in = new ByteArrayInputStream(expectedInputNumber.getBytes());
        System.setIn(in);

        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));

        String actualInputNumber = InputView.askNumberMessage();

        Assertions.assertThat(outputMessage.toString()).isEqualTo("숫자를 입력해주세요: ");
        Assertions.assertThat(actualInputNumber).isEqualTo(expectedInputNumber);

    }


    @Test
    void 재시작_입력_묻기() {
        String expectedInputNumber = "1";

        InputStream in = new ByteArrayInputStream(expectedInputNumber.getBytes());
        System.setIn(in);

        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));

        String actualInputNumber = InputView.askRestartMessage();

        Assertions.assertThat(outputMessage.toString()).isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
        Assertions.assertThat(actualInputNumber).isEqualTo(expectedInputNumber);
    }
}
