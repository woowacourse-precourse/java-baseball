package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class BaseBallGameViewTest {
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
    void 결과_출력_1() {
        String result = "1볼 1스트라이크";
        BaseBallGameView.printResult(1, 1);
        Assertions.assertEquals(result, outputStreamCaptor.toString().trim());
    }

    @Test
    void 결과_출력_2() {
        String result = "낫싱";
        BaseBallGameView.printResult(0, 0);
        Assertions.assertEquals(result, outputStreamCaptor.toString().trim());
    }

    @Test
    void 결과_출력_3() {
        String result = "1볼 1스트라이크";
        BaseBallGameView.printResult(1, 1);
        Assertions.assertEquals(result, outputStreamCaptor.toString().trim());
    }

    @Test
    void 결과_출력_4() {
        String result = "3볼";
        BaseBallGameView.printResult(3, 0);
        Assertions.assertEquals(result, outputStreamCaptor.toString().trim());
    }

    @Test
    void 결과_출력_5() {
        String result = "3스트라이크" + System.lineSeparator() + "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        BaseBallGameView.printResult(0, 3);
        Assertions.assertEquals(result, outputStreamCaptor.toString().trim());
    }

    @Test
    void 결과_출력_6() {
        String result = "2볼";
        BaseBallGameView.printResult(2, 0);
        Assertions.assertEquals(result, outputStreamCaptor.toString().trim());
    }
}