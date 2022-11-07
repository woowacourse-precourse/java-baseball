package inputoutput;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidationTest {
    Validation validator = new Validation();

    @ParameterizedTest
    @CsvSource(value = {"1234,false", "1fd,false", "850,false", "343,false", "243,true", "912,true"})
    void 플레이어_입력_숫자_검사(String playerNumber, boolean expected) {
        assertThat(validator.checkPlayerNumber(playerNumber)).isEqualTo(expected);
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
