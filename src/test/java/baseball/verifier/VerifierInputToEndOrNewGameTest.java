package baseball.verifier;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifierInputToEndOrNewGameTest {
    private final VerifierInputToEndOrNewGame verifier = new VerifierInputToEndOrNewGame();

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void 입력값이_올바른_경우(String input) {
        boolean result;
        result = verifier.validates(input);
        assertThat(true).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "3", "9", "10"})
    void 잘못된_범위의_입력값(String input) {
        boolean result;
        result = verifier.validates(input);
        assertThat(false).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"i", "erdsa", "감사", "#$%&", "\n"})
    void 숫자가아닌_입력값(String input) {
        boolean result;
        result = verifier.validates(input);
        assertThat(false).isEqualTo(result);
    }
}
