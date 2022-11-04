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

    @Test
    void user_input_validation_for_restart() throws IllegalArgumentException {
        assertThatThrownBy(() -> InputValidation.isValidRestartInput("3")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidation.isValidRestartInput("34")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidation.isValidRestartInput("3a4")).isInstanceOf(IllegalArgumentException.class);
    }
}
