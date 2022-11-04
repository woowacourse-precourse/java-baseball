package mytest;

import static org.assertj.core.api.Assertions.*;

import baseball.ResultViewer;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultViewerTest {
    @DisplayName("볼과 스트라이크의 개수가 예상된 프린트문과 똑같이 출력되는지 확인")
    @Test
    void case1() {
        OutputStream expectedPrintout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(expectedPrintout));
        System.out.println("3스트라이크");

        List<Integer> scores = List.of(0, 3);
        OutputStream actualPrintout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualPrintout));
        ResultViewer.printOut(scores);

        assertThat(actualPrintout.toString()).isEqualTo(expectedPrintout.toString());
    }

    @Test
    void case2() {
        OutputStream expectedPrintout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(expectedPrintout));
        System.out.println("2볼");

        List<Integer> scores = List.of(2, 0);
        OutputStream actualPrintout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualPrintout));
        ResultViewer.printOut(scores);

        assertThat(actualPrintout.toString()).isEqualTo(expectedPrintout.toString());
    }

    @Test
    void case3() {
        OutputStream expectedPrintout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(expectedPrintout));
        System.out.println("낫싱");

        List<Integer> scores = List.of(0, 0);
        OutputStream actualPrintout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualPrintout));
        ResultViewer.printOut(scores);

        assertThat(actualPrintout.toString()).isEqualTo(expectedPrintout.toString());
    }

    @Test
    void case4() {
        OutputStream expectedPrintout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(expectedPrintout));
        System.out.println("1볼 1스트라이크");

        List<Integer> scores = List.of(1, 1);
        OutputStream actualPrintout = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualPrintout));
        ResultViewer.printOut(scores);

        assertThat(actualPrintout.toString()).isEqualTo(expectedPrintout.toString());
    }
}
