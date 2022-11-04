package baseball.controller;

import baseball.view.OutputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class NumberBaseballGameControllerTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    void 게임_스타트_전_상대방_생성() {
        NumberBaseballGameController numberBaseballGameController = new NumberBaseballGameController();
        numberBaseballGameController.generateOpponentComputer();
        if (numberBaseballGameController.getOpponentComputer() == null) {
            fail();
        }
    }

    @Test
    void 게임_스타트_시_게임_시작_문구_출력() {
        NumberBaseballGameController numberBaseballGameController = new NumberBaseballGameController();
        String gameStartMessage = "숫자 야구 게임을 시작합니다.\n";
        numberBaseballGameController.gameStart();

        assertThat(output.toString()).isEqualTo(gameStartMessage);
    }
}
