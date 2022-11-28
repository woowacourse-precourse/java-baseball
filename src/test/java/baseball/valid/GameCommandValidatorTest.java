package baseball.valid;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class GameCommandValidatorTest {
    private static final InputValidator inputValidator = new GameCommandValidator();

    @DisplayName("1, 2 중 어느 것도 입력하지 않으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"", "12", "d"})
    void invalidGameCommandTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputValidator.validate(input));
    }

    @DisplayName("1, 2 중 하나를 입력하면 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", " 1 ", " 2 "})
    void validGameCommandTest(String input) {
        assertThatNoException()
                .isThrownBy(() -> inputValidator.validate(input));
    }
}
