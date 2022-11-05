package baseball.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

public class NumberBaseballGameServiceTest {

    @Test
    void 상대방_컴퓨터_생성() {
        NumberBaseballGameService numberBaseballGameService = new NumberBaseballGameService();
        numberBaseballGameService.generateOpponentComputer();
        if (numberBaseballGameService.getOpponentComputer() == null) {
            fail();
        }
    }
}
