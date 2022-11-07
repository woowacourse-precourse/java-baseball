package domain.baseball;

import baseball.domain.baseball.BaseBallGameResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static baseball.domain.baseball.BaseBallGameResult.*;

public class BaseBallGameResultTest {

    private final BaseBallGameResult gameResult = new BaseBallGameResult();

    @Test
    void Nothing메시지_출력() {
        // given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        gameResult.printNothing();

        // when

        // then
        Assertions.assertThat(NOTHING + "\n").isEqualTo(out.toString());
    }

    @Test
    void three볼메시지_출력() {
        // given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        gameResult.printGameResult(3, 0);

        // when

        // then
        Assertions.assertThat("3" + BALL + "\n").isEqualTo(out.toString());

    }

    @Test
    void two볼one스트라이크메시지_출력() {
        // given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        gameResult.printGameResult(2, 1);

        // when

        // then
        Assertions.assertThat("2" + BALL + " " + "1" + STRIKE + "\n").isEqualTo(out.toString());
    }

    @Test
    void three스트라이크메시지_출력() {
        // given
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        gameResult.printGameEnd();

        // when

        // then
        Assertions.assertThat("3" + STRIKE + "\n" + END_MESSAGE + '\n' + RESTART_MESSAGE + '\n').isEqualTo(out.toString());
    }
}
