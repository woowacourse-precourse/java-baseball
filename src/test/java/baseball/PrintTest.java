package baseball;

import constant.JudgeMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.Output;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

public class PrintTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void 스트라이크_볼_갯수_출력_테스트() {
        // given
        int ballCount = 1;
        int strikeCount = 2;
        String expectedMessage = ballCount+ JudgeMessage.BALL + strikeCount+JudgeMessage.STRIKE;

        // when
        Output.printStrikeAndBallCount(ballCount, strikeCount);

        // then
        assertThat(output.toString().trim()).isEqualTo(expectedMessage);
    }

    @Test
    void 스트라이크_갯수_출력_테스트() {
        // given
        int ballCount = 0;
        int strikeCount = 3;
        String expectedMessage = strikeCount+JudgeMessage.STRIKE;

        // when
        Output.printStrikeAndBallCount(ballCount, strikeCount);

        // then
        assertThat(output.toString().trim()).isEqualTo(expectedMessage);
    }

    @Test
    void 볼_갯수_출력_테스트() {
        // given
        int ballCount = 3;
        int strikeCount = 0;
        String expectedMessage = ballCount+ JudgeMessage.BALL.trim();

        // when
        Output.printStrikeAndBallCount(ballCount, strikeCount);

        // then
        assertThat(output.toString().trim()).isEqualTo(expectedMessage);
    }

    @Test
    void 낫싱_출력_테스트() {
        // given
        int ballCount = 0;
        int strikeCount = 0;
        String expectedMessage = JudgeMessage.NOTHING;

        // when
        Output.printStrikeAndBallCount(ballCount, strikeCount);

        // then
        assertThat(output.toString().trim()).isEqualTo(expectedMessage);
    }
}
