package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HintTest {
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void 볼_개수가_0개_스트라이크_개수가_0개인_경우() {
        Count count = new Count(0, 0);

        Hint.show(count);

        assertEquals("낫싱", outputStreamCaptor.toString().trim());
    }

    @Test
    public void 볼_개수가_1개_이상_스트라이크_개수가_0개인_경우() {
        Count count = new Count(2, 0);

        Hint.show(count);

        assertEquals("2볼", outputStreamCaptor.toString().trim());
    }

    @Test
    public void 볼_개수가_0개_스트라이크_개수가_1개_이상인_경우() {
        Count count = new Count(0, 3);

        Hint.show(count);

        assertEquals("3스트라이크", outputStreamCaptor.toString().trim());
    }

    @Test
    public void 볼_개수가_1개_이상_스트라이크_개수가_1개_이상인_경우() {
        Count count = new Count(2, 1);

        Hint.show(count);

        assertEquals("2볼 1스트라이크", outputStreamCaptor.toString().trim());
    }
}
