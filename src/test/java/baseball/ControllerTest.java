package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ControllerTest {
    Controller controller;

    @BeforeEach
    void 모델_생성자() {
        controller = new Controller();
    }

    @Test
    void 랜덤_숫자_생성기() {
        assertTrue(isCorrectRange(controller.randomNumber()));
    }

    boolean isCorrectRange(String randomnumber) {
        boolean decision = true;
        int irandomnumber = Integer.parseInt(randomnumber);

        if(irandomnumber < 100 || irandomnumber > 999) {
            decision = false;
        }

        if(randomnumber.contains("0")) {
            decision = false;
        }

        return decision;
    }
}
