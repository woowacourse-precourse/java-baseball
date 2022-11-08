package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class VerifyUserNumberTest {
    private final Application application = new Application();

    @Test void verifyUserNumber_사용자가_입력한_숫자가_3자리가_아닐_경우() {
        String input = "12345";
        assertThatThrownBy(() -> Application.verifyUserNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test void verifyUserNumber_사용자가_입력한_숫자에_0이_포함된_경우() {
        String input = "120";
        assertThatThrownBy(() -> Application.verifyUserNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test void verifyUserNumber_사용자가_올바른_숫자를_입력한_경우() {
        String input = "123";
        assertThat(Application.verifyUserNumber(input)).isEqualTo("123");
    }
}
