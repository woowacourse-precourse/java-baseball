package baseball.controller;


import baseball.view.InputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberBaseballGameControllerTest {

    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void 게임_재시작_시_gameStatus_play(String input) {
        NumberBaseballGameController numberBaseballGameController = new NumberBaseballGameController();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        numberBaseballGameController.gameRestartOrEnd();
        String gameStatus = numberBaseballGameController.getGameStatus();

        assertThat(gameStatus).isEqualTo("play");
    }
}
