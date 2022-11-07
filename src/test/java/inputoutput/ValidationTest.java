package inputoutput;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationTest {
    Validation validator = new Validation();

    @Test
    void 플레이어_입력_숫자_검사() {
        boolean validateValue = validator.checkPlayerNumber("134");
        assertThat(validateValue).isEqualTo(true);
    }

    @Test
    void 플레이어_입력_숫자_구성_검사() {
        boolean validateValue = validator.checkPlayerNumber("1f4");
        assertThat(validateValue).isEqualTo(false);
    }

    @Test
    void 플레이어_입력_숫자_길이_검사() {
        boolean validateValue = validator.checkPlayerNumber("1234");
        assertThat(validateValue).isEqualTo(false);
    }

    @Test
    void 플레이어_입력_숫자_중복_검사() {
        boolean validateValue = validator.checkPlayerNumber("252");
        assertThat(validateValue).isEqualTo(false);
    }

}
