package baseball.domain;

import baseball.utils.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class NumberBaseballTest extends NumberBaseball{
    private NumberBaseball numberBaseball;
    @BeforeEach
    public void setup() {
        numberBaseball = new NumberBaseball();
    }

    @Test
    public void testCompareNumbersAfterRead() {
        String inputString = "123";
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateUserNumber("1234");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateUserNumber("133");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateUserNumber("asd");
        });
        numberBaseball.compareComputerNumberWith(inputString);
        assertThat(numberBaseball.getGameResult().length() > 0).isTrue();
    }

    @Test
    public void testArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
           Validator.validateResumeNumber("3");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateResumeNumber("asdf");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateUserNumber("032");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateResumeNumber("133");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateResumeNumber("32");
        });
    }
}