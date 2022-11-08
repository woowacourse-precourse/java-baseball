package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import baseball.tools.GenerateNumber;
import baseball.tools.Validator;

public class GenerateNumberTest {

    @Test
    void GenerateNumber_정답_올바른숫자가생성되었는지() {
        GenerateNumber number = new GenerateNumber();
        Validator validator = new Validator(String.valueOf(number.pickThreeUniqueRandomNumber()));
        boolean result = validator.checkBaseballNumber();

        assertThat(result).isTrue();
    }
}
