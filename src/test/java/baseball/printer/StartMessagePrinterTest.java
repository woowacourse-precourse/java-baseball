package baseball.printer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StartMessagePrinterTest {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    PrintStream originalErr = System.err;

    MessagePrinter startMessagePrinter;

    @BeforeEach
    void init() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        startMessagePrinter = new StartMessagePrinter();
    }

    @Test
    @DisplayName("게임 시작 메세지 출력")
    void printStartMessageTest() {
        //given
        String expect = "숫자 야구 게임을 시작합니다.\n";

        //when
        startMessagePrinter.printMessage();

        //then
        assertThat(outContent.toString()).isEqualTo(expect);
    }

    @AfterEach
    void reset() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}