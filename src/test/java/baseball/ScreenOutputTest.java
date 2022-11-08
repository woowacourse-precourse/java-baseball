package baseball;

import IOController.ScreenOutput;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class ScreenOutputTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    @Order(1)
    void computerPrintStartGame() {
        ScreenOutput.testComputerPrint(1, "");
        Assertions.assertThat("숫자 야구 게임을 시작합니다.").isEqualTo(outContent.toString().trim());
    }

    @Test
    @Order(2)
    void computerPrintInputNumber() {
        ScreenOutput.testComputerPrint(2, "");
        Assertions.assertThat("숫자를 입력해주세요 : ").isEqualTo(outContent.toString());
    }

    @Test
    @Order(3)
    void computerPrintCalculatorResult() {
        ScreenOutput.testComputerPrint(4, "1볼 1스트라이크");
        Assertions.assertThat("1볼 1스트라이크").isEqualTo(outContent.toString().trim());
    }

    @Test
    @Order(4)
    void computerPrintCalculatorResultNothing() {
        ScreenOutput.testComputerPrint(4, "낫싱");
        Assertions.assertThat("낫싱").isEqualTo(outContent.toString().trim());
    }

    @Test
    @Order(4)
    void computerPrintCalculatorEnding() {
        ScreenOutput.testComputerPrint(3, "");
        Assertions.assertThat("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.").isEqualTo(outContent.toString().trim());
    }

}