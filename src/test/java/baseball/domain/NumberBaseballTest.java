package baseball.domain;

import baseball.utils.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberBaseballTest extends NumberBaseball{
    private NumberBaseball numberBaseball;
    @BeforeEach
    void setup() {
        numberBaseball = new NumberBaseball();
    }

    @Test
    void testComputerHasDifferent3Numbers() {
        assertThat(Validator.hasDifferentNumbers(numberBaseball.getComputerNumber()))
                .isTrue();
    }

    @Test
    void testCompareNumbersAfterRead() {
        String inputString = "123";
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateUserNumber("1234");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateUserNumber("133");
        });
        numberBaseball.compareComputerNumberWith(inputString);
        assertThat(numberBaseball.getGameResult().length() > 0).isTrue();
    }
}