package baseball.view;

import baseball.util.GameNumberGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;

import static baseball.view.OutputView.*;
import static org.assertj.core.api.Assertions.*;

public class OutputViewTest {

    static OutputView outputView;
    static OutputStream outputStream;

    @BeforeAll
    static void setup() {
        outputView = new OutputView();
    }

    void initOutputStream() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void 메시지_테스트() {
        initOutputStream();
        outputView.printStart();
        assertThat(START_MESSAGE + "\r\n").isEqualTo(outputStream.toString());
        initOutputStream();
        outputView.printEnd();
        assertThat(END_MESSAGE + "\r\n").isEqualTo(outputStream.toString());
        initOutputStream();
        outputView.printInputNumber();
        assertThat(INPUT_NUMBER_MESSAGE).isEqualTo(outputStream.toString());
        initOutputStream();
        outputView.printInputRetry();
        assertThat(INPUT_RETRY_MESSAGE + "\r\n").isEqualTo(outputStream.toString());
    }

    @Test
    void 결과_메시지_낫싱_테스트() {
        initOutputStream();
        outputView.printResult(0, 0);
        assertThat(NOTHING_MESSAGE + "\r\n").isEqualTo(outputStream.toString());
    }

    @Test
    void 결과_메시지_온리_볼_테스트() {
        for (int i = 1; i <= GameNumberGenerator.GAME_NUMBER_LENGTH; i++) {
            initOutputStream();
            outputView.printResult(i, 0);
            assertThat(i + BALL_MESSAGE + "\r\n").isEqualTo(outputStream.toString());
        }
    }

    @Test
    void 결과_메시지_온리_스트라이크_테스트() {
        for (int i = 1; i <= GameNumberGenerator.GAME_NUMBER_LENGTH; i++) {
            initOutputStream();
            outputView.printResult(0, i);
            assertThat(i + STRIKE_MESSAGE + "\r\n").isEqualTo(outputStream.toString());
        }
    }

    @Test
    void 결과_메시지_나머지_테스트() {
        for (int i = 1; i * 2 <= GameNumberGenerator.GAME_NUMBER_LENGTH; i++) {
            initOutputStream();
            int ball = i;
            int strike = i;
            outputView.printResult(ball, strike);
            assertThat(ball + BALL_MESSAGE + " " + strike + STRIKE_MESSAGE + "\r\n").isEqualTo(outputStream.toString());
        }
        for (int i = 1; i < GameNumberGenerator.GAME_NUMBER_LENGTH; i++) {
            initOutputStream();
            int ball = i;
            int strike = GameNumberGenerator.GAME_NUMBER_LENGTH - ball;
            outputView.printResult(ball, strike);
            assertThat(ball + BALL_MESSAGE + " " + strike + STRIKE_MESSAGE + "\r\n").isEqualTo(outputStream.toString());
        }
    }

}
