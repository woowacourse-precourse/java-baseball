package inputoutput;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ValidationTest {
    Validation validator = new Validation();

    @Test
    void 플레이어_입력_숫자_검사() {
        boolean validateValue = validator.checkPlayerNumber("134");
        assertThat(validateValue).isEqualTo(true);
    }

    @Test
    void 플레이어_입력_숫자_구성_예외_발생() {
        assertThatThrownBy(() -> validator.checkPlayerNumber("1f5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 플레이어_입력_숫자_길이_예외_발생() {
        assertThatThrownBy(() -> validator.checkPlayerNumber("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
