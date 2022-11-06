package baseball;

import baseball.model.ComputerNumber;
import baseball.model.UserNumber;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class FunctionTest {
    @Test
    void ComputerNumber이_중복되지_않은_1에서_9사이의_3자리_숫자인지() {
        ComputerNumber computerNumber = new ComputerNumber();
        computerNumber.setComputerNumber();
        Set<Integer> checkDuplicate = new HashSet<>(computerNumber.getComputerNumber());

        assertThat(computerNumber.getComputerNumber()
                .size())
                .isEqualTo(3);

        assertThat(checkDuplicate.size())
                .isEqualTo(computerNumber.getComputerNumber().size());

        for (int i = 0; i < 3; i++) {

            assertThat(computerNumber.getComputerNumber().get(i))
                    .isBetween(1, 9);

        }
    }
    @Test
    void 입력된_input이_숫자인가() {
        UserNumber userNumber = new UserNumber();

        assertTrue(userNumber.isInputDigit("123"));
        assertFalse(userNumber.isInputDigit("QWER"));
        assertFalse(userNumber.isInputDigit("11월"));

    }
    @Test
    void 입력된_input이_3글자인가() {
        UserNumber userNumber = new UserNumber();

        assertFalse(userNumber.isInputLengthUnder3("12"));
        assertFalse(userNumber.isInputLengthUnder3("126890"));
        assertTrue(userNumber.isInputLengthUnder3("179"));

    }
    @Test
    void 입력된_input이_중복이_아닌가() {
        UserNumber userNumber = new UserNumber();

        assertFalse(userNumber.isInputNotDuplicate("333"));
        assertFalse(userNumber.isInputNotDuplicate("332"));
        assertTrue(userNumber.isInputNotDuplicate("123"));

    }
    @Test
    void 입력된_input이_1에서_9까지의_숫자인가() {
        UserNumber userNumber = new UserNumber();

        assertFalse(userNumber.isBetween1to9("320"));
        assertTrue(userNumber.isBetween1to9("323"));
    }
}

