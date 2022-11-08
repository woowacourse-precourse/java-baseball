package baseball.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputTest {

    private static ByteArrayOutputStream outContent;
    private Output output;

    @BeforeEach
    public void setOutputClass() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        output = new Output();
    }

    @Test
    void 볼_스트라이크_출력1() {
        List<Integer> result = List.of(0, 0);
        output.printStrikeBall(result);
        assertEquals("낫싱", outContent.toString().trim());

    }

    @Test
    void 볼_스트라이크_출력2() {
        List<Integer> result = List.of(0, 1);
        output.printStrikeBall(result);
        assertEquals("1볼", outContent.toString().trim());
    }

    @Test
    void 볼_스트라이크_출력3() {
        List<Integer> result = List.of(0, 2);
        output.printStrikeBall(result);
        assertEquals("2볼", outContent.toString().trim());
    }

    @Test
    void 볼_스트라이크_출력4() {
        List<Integer> result = List.of(0, 3);
        output.printStrikeBall(result);
        assertEquals("3볼", outContent.toString().trim());
    }

    @Test
    void 볼_스트라이크_출력5() {
        List<Integer> result = List.of(1, 0);
        output.printStrikeBall(result);
        assertEquals("1스트라이크", outContent.toString().trim());
    }

    @Test
    void 볼_스트라이크_출력6() {
        List<Integer> result = List.of(2, 0);
        output.printStrikeBall(result);
        assertEquals("2스트라이크", outContent.toString().trim());
    }

    @Test
    void 볼_스트라이크_출력7() {
        List<Integer> result = List.of(3, 0);
        output.printStrikeBall(result);
        assertEquals("3스트라이크", outContent.toString().trim());
    }

    @Test
    void 볼_스트라이크_출력8() {
        List<Integer> result = List.of(1, 1);
        output.printStrikeBall(result);
        assertEquals("1볼 1스트라이크", outContent.toString().trim());
    }

    @Test
    void 볼_스트라이크_출력9() {
        List<Integer> result = List.of(1, 2);
        output.printStrikeBall(result);
        assertEquals("2볼 1스트라이크", outContent.toString().trim());
    }
}