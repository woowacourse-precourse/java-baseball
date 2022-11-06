package baseball;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class UserNumberTest {

    User user = new User();

    @ParameterizedTest
    @ValueSource(strings = {"23", "3uh", "i", " ", "", "112", "0", "012"})
    void 입력받은_숫자_검증(String input) {
        assertThatThrownBy(() -> {
            user.isValidInput(input);
        })
                .isInstanceOf(IllegalArgumentException.class);
    }
}
