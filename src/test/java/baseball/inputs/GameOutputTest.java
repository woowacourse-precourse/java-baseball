package baseball.inputs;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameOutputTest{
    GameOutput output = new GameOutput();
    static OutputStream out;

    @BeforeEach
    void before(){
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void after() throws IOException {
        out.flush();
    }

    @Test
    void printPlayingCount_case1() {
        int strike = 3;
        int ball = 0;
        output.printPlayingCount(strike,ball);
        String expectedResult = "3스트라이크\n";
        Assertions.assertEquals(expectedResult,out.toString());
    }

    @Test
    void printPlayingCount_case2() {
        int strike = 2;
        int ball = 1;
        output.printPlayingCount(strike,ball);
        String expectedResult = "1볼 2스트라이크\n";
        Assertions.assertEquals(expectedResult,out.toString());
    }

    @Test
    void printPlayingCount_case3() {
        int strike = 1;
        int ball = 2;
        output.printPlayingCount(strike,ball);
        String expectedResult = "2볼 1스트라이크\n";
        Assertions.assertEquals(expectedResult,out.toString());
    }

    @Test
    void printPlayingCount_case4() {
        int strike = 0;
        int ball = 3;
        output.printPlayingCount(strike,ball);
        String expectedResult = "3볼\n";
        Assertions.assertEquals(expectedResult,out.toString());
    }

    @Test
    void printPlayingCount_case5() {
        int strike = 0;
        int ball = 0;
        output.printPlayingCount(strike,ball);
        String expectedResult = "낫싱\n";
        Assertions.assertEquals(expectedResult,out.toString());
    }

    @Test
    void printPlayingCount_error1() {
        int strike = -1;
        int ball = 0;
        assertThatThrownBy(() -> output.printPlayingCount(strike,ball))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void printPlayingCount_error2() {
        int strike = 4;
        int ball = 1;
        assertThatThrownBy(() -> output.printPlayingCount(strike,ball))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void printPlayingCount_error3() {
        int strike = 2;
        int ball = -1;
        assertThatThrownBy(() -> output.printPlayingCount(strike,ball))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void printPlayingCount_error4() {
        int strike = 1;
        int ball = 5;
        assertThatThrownBy(() -> output.printPlayingCount(strike,ball))
                .isInstanceOf(IllegalArgumentException.class);
    }
}