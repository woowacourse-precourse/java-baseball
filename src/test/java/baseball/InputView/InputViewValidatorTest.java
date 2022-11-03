package baseball.InputView;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.inputview.InputViewValidator;
import org.junit.jupiter.api.Test;

public class InputViewValidatorTest {
    @Test
    void check_Input() {
        assertThat(InputViewValidator.validateSize(4)).isFalse();
        assertThat(InputViewValidator.validateSize(2)).isFalse();
        assertThat(InputViewValidator.validateSize(3)).isTrue();
    }

    @Test
    void check_different_number() {
        assertThat(InputViewValidator.validateDifferenceNumber(233)).isFalse();
        assertThat(InputViewValidator.validateDifferenceNumber(234)).isTrue();
    }
}
