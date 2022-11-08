package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static baseball.Application.*;
import static baseball.Application.isDuplicate;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputViewTest {
    @Test
    void isNumericTest() {
        String string1 = "135";
        boolean result1 = true;
        assertThat(isNumeric(string1)).isEqualTo(result1);
        String string2 = "1-3";
        boolean result2 = false;
        assertThat(isNumeric(string2)).isEqualTo(result2);
        String string3 = "102";
        boolean result3 = false;
        assertThat(isNumeric(string3)).isEqualTo(result3);
    }

    @Test
    void isDuplicateTest() {
        String string1 = "113";
        boolean result1 = true;
        assertThat(isDuplicate(string1)).isEqualTo(result1);
        String string2 = "987";
        boolean result2 = false;
        assertThat(isDuplicate(string2)).isEqualTo(result2);
    }

    @Test
    void validateNumberExceptionTest() {
        List<String> userInputList = Arrays.asList("9873", "1121", "--1");
        for (int i = 0; i < 3; i++) {
            String userInput = userInputList.get(i);
            assertThatIllegalArgumentException().isThrownBy(() ->
                    validateNumber(userInput));
        }
    }
}
