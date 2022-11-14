package mytest;

import static org.assertj.core.api.Assertions.*;

import baseball.settings.ResultViewer;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultViewerTest {
    @DisplayName("출력 테스트 - 3스트라이크")
    @Test
    void case1() {
        OutputStream actualPrintout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualPrintout));
        List<Integer> scores = List.of(0, 3);
        ResultViewer.printOut(scores);

        OutputStream expectedPrintout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(expectedPrintout));
        System.out.println("3스트라이크");

        assertThat(actualPrintout.toString()).isEqualTo(expectedPrintout.toString());
    }

    @DisplayName("출력 테스트 - 2볼")
    @Test
    void case2() {
        OutputStream actualPrintout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualPrintout));
        List<Integer> scores = List.of(2, 0);
        ResultViewer.printOut(scores);

        OutputStream expectedPrintout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(expectedPrintout));
        System.out.println("2볼");

        assertThat(actualPrintout.toString()).isEqualTo(expectedPrintout.toString());
    }

    @DisplayName("출력 테스트 - 낫싱")
    @Test
    void case3() {
        OutputStream actualPrintout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualPrintout));
        List<Integer> scores = List.of(0, 0);
        ResultViewer.printOut(scores);

        OutputStream expectedPrintout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(expectedPrintout));
        System.out.println("낫싱");

        assertThat(actualPrintout.toString()).isEqualTo(expectedPrintout.toString());
    }

    @DisplayName("출력 테스트 - 1볼 1스트라이크")
    @Test
    void case4() {
        OutputStream actualPrintout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualPrintout));
        List<Integer> scores = List.of(1, 1);
        ResultViewer.printOut(scores);

        OutputStream expectedPrintout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(expectedPrintout));
        System.out.println("1볼 1스트라이크");

        assertThat(actualPrintout.toString()).isEqualTo(expectedPrintout.toString());
    }
}
