package baseball;

import baseball.result.ResultPrinter;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResultPrinterTest {
    @Test
    void case1() {
        ResultPrinter resultPrinter = new ResultPrinter();
        OutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        resultPrinter.printResult("123", "124");
        assertThat(captor.toString().trim()).contains("2스트라이크");
    }

    @Test
    void case2() {
        ResultPrinter resultPrinter = new ResultPrinter();
        OutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        resultPrinter.printResult("589", "985");
        assertThat(captor.toString().trim()).contains("2볼 1스트라이크");
    }

    @Test
    void case3() {
        ResultPrinter resultPrinter = new ResultPrinter();
        OutputStream captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
        resultPrinter.printResult("467", "467");
        assertThat(captor.toString().trim()).contains("3스트라이크");
    }


}
