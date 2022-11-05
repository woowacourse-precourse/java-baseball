package baseball;

import java.io.*;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void setUserInput_WhenRun_PrintStartStatement() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        User.setUserInput(input);
        assertThat(out.toString()).isEqualTo("숫자를 입력해주세요 : ");
    }
}