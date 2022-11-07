package baseball.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("1볼 1스트라이크")
    void ball_and_strike() {
        int strike = 1;
        int ball = 1;

        OutputView.printGameResult(strike, ball);
        assertEquals("1볼 1스트라이크", outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("2스트라이크")
    void only_strike() {
        int strike = 2;
        int ball = 0;

        OutputView.printGameResult(strike, ball);
        assertEquals("2스트라이크", outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("2볼")
    void only_ball() {
        int strike = 0;
        int ball = 2;

        OutputView.printGameResult(strike, ball);
        assertEquals("2볼", outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("낫싱")
    void nothing() {
        int strike = 0;
        int ball = 0;

        OutputView.printGameResult(strike, ball);
        assertEquals("낫싱", outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("게임 종료")
    void gameEnd() {
        int strike = 3;
        int ball = 0;

        OutputView.printGameResult(strike, ball);
        assertEquals("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료", outputStreamCaptor.toString().trim());
    }
}