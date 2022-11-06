package baseball;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
public class NumberTest {

    Number number;

    @BeforeEach
    void initialize() {
        number = new Number();
    }

    @Test
    void 컴퓨터_수_조건_확인() {
        number.setRandomNumber();
        List<Integer> digits = number.getDigits();
        String target = "";
        for (Integer digit : digits) {
            target += Integer.toString(digit);
        }
        assertTrue(number.isValid(target));
    }
}
