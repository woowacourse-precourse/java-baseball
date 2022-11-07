package baseball.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


class BaseballGameViewTest {

    BaseballGameView baseballGameView = new BaseballGameView();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void 낫싱() {
        Integer strike = 0;
        Integer ball = 0;

        baseballGameView.gameResultMessage(strike, ball);

        Assertions.assertThat(outContent.toString().replace("\n", "")).isEqualTo("낫싱");
    }

    @Test
    void 원스트라이크() {
        Integer strike = 1;
        Integer ball = 0;

        baseballGameView.gameResultMessage(strike, ball);

        Assertions.assertThat(outContent.toString().replace("\n", "")).isEqualTo("1스트라이크");
    }

    @Test
    void 원볼() {
        Integer strike = 0;
        Integer ball = 1;

        baseballGameView.gameResultMessage(strike, ball);

        Assertions.assertThat(outContent.toString().replace("\n", "")).isEqualTo("1볼");
    }

    @Test
    void 원스트라이크_원볼() {
        Integer strike = 1;
        Integer ball = 1;

        baseballGameView.gameResultMessage(strike, ball);

        Assertions.assertThat(outContent.toString().replace("\n", "")).isEqualTo("1볼 1스트라이크");
    }

}