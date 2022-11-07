package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void printResultTest() {
        OutputView outputView = new OutputView();
        int strike = 1;
        int ball = 1;
        outputView.printResult(strike, ball);
        assertEquals("1볼 1스트라이크", outputStreamCaptor.toString().trim());
    }

}