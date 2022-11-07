package baseball.Utils;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.Utils.Input;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

class InputTest {

    @Test
    void getThreeNumbers_PrintInputStatement_True() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Input.getThreeNumbers();
        assertThat(out.toString()).isEqualTo("숫자를 입력해주세요 : ");
    }

    @Test
    void getThreeNumbers_GettingUserInput_ReturnInputString() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String user_input = Input.getThreeNumbers();
        assertThat(user_input).isEqualTo(input);
    }

    @Test
    void getResetOrQuit_PrintInputStatement_True() {
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Input.getResetOrQuit();
        assertThat(out.toString()).isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." + System.lineSeparator());
    }

    @Test
    void getResetOrQuit_GettingUserInput_ReturnInputString() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String user_input = Input.getResetOrQuit();
        assertThat(user_input).isEqualTo(input);
    }
}