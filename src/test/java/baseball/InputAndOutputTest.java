package baseball;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class InputAndOutputTest {

    @Test
    void 사용자_숫자_입력_받기_검증() {
        String answer = "123";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(answer.getBytes());
        System.setIn(in);

        String userAnswer = InputAndOutput.getUserAnswer();
        Assertions.assertThat(userAnswer).isEqualTo("123");
    }
}