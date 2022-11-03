package baseball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputNumberValidateTest {
    @ParameterizedTest
    @ValueSource(strings = {" ", "1", "12", "1234"})
    void INVALID_INPUT_LENGTH_숫자를_3개만_입력(String input) {
        Game game = new Game();
        assertThatThrownBy(() -> game.validate(input))
                .hasMessage(Game.INVALID_INPUT_LENGTH);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "숫자만"})
    void INVALID_INPUT_TYPE_숫자만_입력(String input) {
        Game game = new Game();
        assertThatThrownBy(() -> game.validate(input))
                .hasMessage(Game.INVALID_INPUT_TYPE);
    }
}
