package baseball;

import baseball.controller.GameController;
import baseball.model.ComputerNumber;
import baseball.model.UserNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class FunctionTest {
    ComputerNumber computerNumber;
    UserNumber userNumber;

    @BeforeEach
    void setting() {
        computerNumber = new ComputerNumber();
        computerNumber.setComputerNumber();
        userNumber = new UserNumber();
    }

    @Test
    void 생성된_ComputerNumber가_3자리인지() {
        assertThat(computerNumber.getComputerNumber()
                .size())
                .isEqualTo(3);
    }

    @Test
    void 생성된_ComputerNumber가_1에서_9사이인지() {
        for (int i = 0; i < 3; i++) {
            assertThat(computerNumber.getComputerNumber().get(i))
                    .isBetween(1, 9);
        }
    }

    @Test
    void 생성된_ComputerNumber가_중복인지_아닌지() {
        Set<Integer> checkDuplicate = new HashSet<>(computerNumber.getComputerNumber());

        assertThat(checkDuplicate.size())
                .isEqualTo(computerNumber.getComputerNumber().size());
    }

    @Test
    void 입력된_input이_숫자인가() {
        assertTrue(userNumber.isInputDigit("123"));
        assertFalse(userNumber.isInputDigit("QWER"));
        assertFalse(userNumber.isInputDigit("11월"));
    }

    @Test
    void 입력된_input이_3글자인가() {
        assertFalse(userNumber.isInputLengthUnder3("12"));
        assertFalse(userNumber.isInputLengthUnder3("126890"));
        assertTrue(userNumber.isInputLengthUnder3("179"));
    }

    @Test
    void 입력된_input이_중복이_아닌가() {
        assertFalse(userNumber.isInputNotDuplicate("333"));
        assertFalse(userNumber.isInputNotDuplicate("332"));
        assertTrue(userNumber.isInputNotDuplicate("123"));
    }

    @Test
    void 입력된_input이_1에서_9까지의_숫자인가() {
        assertFalse(userNumber.isBetween1to9("320"));
        assertTrue(userNumber.isBetween1to9("323"));
    }

    @Test
    void 스트라이크_볼_갯수_test() {
        GameController gameController = new GameController();
        gameController.calculateScore(List.of(1, 2, 3), List.of(1, 2, 3));

        assertEquals(gameController.getStrike(), 3);
        assertEquals(gameController.getBall(), 0);
    }

    @Test
    void 입력된_input이_1또는_2인가() {
        assertTrue(userNumber.isBetween1to2("1"));
        assertTrue(userNumber.isBetween1to2("2"));
        assertFalse(userNumber.isBetween1to2("3"));
    }
}

