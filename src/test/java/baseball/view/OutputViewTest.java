package baseball.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private PrintStream standardOut;
    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    void setUp() {
        standardOut = System.out;
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void printOutput() {
        System.setOut(standardOut);
        System.out.println(outputStreamCaptor.toString().trim());
    }

    @Test
    void gameStartMessage_메서드_출력() {
        OutputView.gameStartMessage();

        assertThat(outputStreamCaptor.toString()).contains(OutputView.GAME_START_MESSAGE);
    }

    @Test
    void inputNumberMessage_메서드_출력() {
        OutputView.inputNumberMessage();

        assertThat(outputStreamCaptor.toString()).contains(OutputView.INPUT_NUMBER_MESSAGE);
    }

    @Test
    void print_메서드_출력() {
        OutputView.print("메세지");

        assertThat(outputStreamCaptor.toString()).contains("메세지");
    }

    @Test
    void gameEndMessage_메서드_출력() {
        OutputView.gameEndMessage();

        assertThat(outputStreamCaptor.toString()).contains(OutputView.GAME_END_MESSAGE);
    }

    @Test
    void endOrRestartMessage_메서드_출력() {
        OutputView.endOrRestartMessage();

        assertThat(outputStreamCaptor.toString()).contains(OutputView.END_OR_RESTART_MESSAGE);
    }

}