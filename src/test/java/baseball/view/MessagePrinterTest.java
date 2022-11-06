package baseball.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MessagePrinterTest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;
    final MessagePrinter messagePrinter = new MessagePrinterImpl();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void printGameStart() {
        //given
        String expectOutput = "숫자 야구 게임을 시작합니다.";

        //when
        messagePrinter.printGameStart();

        //then
        assertEquals(expectOutput, outputStreamCaptor.toString().trim());
    }
}