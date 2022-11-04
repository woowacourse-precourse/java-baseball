package baseball.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class NumberBaseballGameControllerTest {

    @Test
    void 게임_스타트_전_상대방_생성() {
        NumberBaseballGameController numberBaseballGameController = new NumberBaseballGameController();
        numberBaseballGameController.generateOpponentComputer();
        if (numberBaseballGameController.getOpponentComputer() == null) {
            fail();
        }
    }
}
