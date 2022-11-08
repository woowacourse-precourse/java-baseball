package baseball;

import baseball.controller.GameController;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class InputNumberTest {
    GameController testController;

    @BeforeEach
    void beforeEach() {
        testController = new GameController();
    }

    @Test
    void 입력수중중복수() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testController.checkInputNum("112");
        });
    }

    @Test
    void 입력수중숫자부족() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testController.checkInputNum("12");
        });
    }

    @Test
    void 입력수중0포함() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testController.checkInputNum("120");
        });
    }

    @Test
    void 입력수중숫자아님() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testController.checkInputNum("king");
        });
    }

    @Test
    void 응답수가12모두아님() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testController.checkInputNum("3");
        });
    }

    @Test
    void 응답수가숫자아님() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testController.checkInputNum("queen");
        });
    }

}
