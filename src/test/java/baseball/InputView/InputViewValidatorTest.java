package baseball.InputView;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.view.inputview.InputViewValidator;
import org.junit.jupiter.api.Test;

public class InputViewValidatorTest {
    @Test
    void check_Input() {
        assertThat(InputViewValidator.validateSize("2345")).isFalse();
        assertThat(InputViewValidator.validateSize("23")).isFalse();
        assertThat(InputViewValidator.validateSize("123")).isTrue();
    }

    @Test
    void check_different_number() {
        assertThat(InputViewValidator.validateDifferenceNumber("224")).isFalse();
        assertThat(InputViewValidator.validateDifferenceNumber("234")).isTrue();
    }
}
