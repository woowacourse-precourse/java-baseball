package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberBaseballGameClientTest {

    private PrintStream standardOut;
    private OutputStream captor;
    private InputStream standardIn;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        standardIn = System.in;
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.setIn(standardIn);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().replaceAll("(\r\n|\r|\n|\n\r)", "");
    }

    private void input(final String... args) {
        final byte[] buffer = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buffer));
    }

    @Test
    void 게임_시작_메시지는_출력스트림에_정상_저장된다() {
        NumberBaseballGameClient.showGameStartMessage();
        assertThat(output()).isEqualTo("숫자 야구 게임을 시작합니다.");
    }
}