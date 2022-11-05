package baseball.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void gameStartMessage_메서드_검증() {
        OutputView.gameStartMessage();

        assertThat(outputStreamCaptor.toString()).contains(OutputView.GAME_START_MESSAGE);
    }

    @Test
    void inputNumberMessage_메서드_검증() {
        OutputView.inputNumberMessage();

        assertThat(outputStreamCaptor.toString()).contains(OutputView.INPUT_NUMBER_MESSAGE);
    }

}