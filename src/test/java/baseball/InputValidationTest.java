package baseball;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class InputValidationTest {

    @Test
    void user_input_validation() throws IllegalArgumentException {
        assertThatThrownBy(() -> InputValidation.isValidInput("098")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidation.isValidInput("999")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidation.isValidInput("asd")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidation.isValidInput("a123")).isInstanceOf(IllegalArgumentException.class);
    }
}
