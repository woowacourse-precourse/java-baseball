package baseball.valid;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class PlayerNumberValidatorTest {

    private static final InputValidator inputValidator = new PlayerNumberValidator();

    @DisplayName("1에서 9까지의 서로 다른 임의의 3가지 수가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"12j", "012", "112", "", "1234", "999999999999999999999"})
    void invalidPlayerNumberTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputValidator.validate(input));
    }

    @DisplayName("1에서 9까지 서로 다른 임의의 3자리 수이면 예외가 발생하지 않는다")
    @Test
    void validPlayerNumberTest() {
        assertThatNoException()
                .isThrownBy(() -> inputValidator.validate("123"));
    }
}
