package baseball.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp()  {
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void start() {
        Output.start();

        assertThat(outputStream.toString()).contains("숫자 야구 게임을 시작합니다.");
    }
}
