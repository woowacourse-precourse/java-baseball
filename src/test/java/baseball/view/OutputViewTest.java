package baseball.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void gameStartMessage_메서드_검증() {
        OutputView.gameStartMessage();

        assertThat(outputStreamCaptor.toString().trim()).contains(GAME_START_MESSAGE);
    }

}