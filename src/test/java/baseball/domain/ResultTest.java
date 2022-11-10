package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ResultTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Result result;

    @BeforeEach
    public void setUp() {
        result = new Result();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void reportTest1() {
        result.report(Judgement.STRIKE);
        assertThat(result).isEqualTo(new Result(0,1));
    }

    @Test
    public void resultTest2() {
        result.report(Judgement.BALL);
        assertThat(result).isEqualTo(new Result(1,0));
    }

    @Test
    public void resultTest3() {
        result.report(Judgement.NOTHING);
        assertThat(result).isEqualTo(new Result(0,0));
    }

    @ParameterizedTest
    @CsvSource({"0,0,낫싱","1,1,1볼 1스트라이크","3,0,3볼","0,3,3스트라이크"})
    public void printTest(int ball, int strike, String out) {
        System.out.print(new Result(ball, strike));
        assertEquals(out, outContent.toString());
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
