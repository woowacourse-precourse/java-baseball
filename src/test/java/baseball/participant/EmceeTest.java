package baseball.participant;

import baseball.result.ResultType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

class EmceeTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void showResultMessage() {
        // given
        Emcee emcee = new Emcee();

        // when
        emcee.showResultMessage(ResultType.BALL_AND_STRIKE, 2, 1);

        // then
        assertThat(outContent.toString()).contains("2볼 1스트라이크");
    }
}