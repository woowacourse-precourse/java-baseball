package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidationTest {
    @Test
    void validateBaseballInput_게임규격외_예외발생() {
        String str1 = "290";
        String str2 = "321";
        String str3 = "";
        String str4 = "4213";
        String str5 = "322";

        assertDoesNotThrow(() -> {
            Validation.validateResetInput(str1);
        });

        assertDoesNotThrow(() -> {
            Validation.validateResetInput(str2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateResetInput(str3);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateResetInput(str4);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateResetInput(str5);
        });
    }

    @Test
    void hasNonDigit_모두_숫자인지_판별() {
        String str1 = "1.2";
        String str2 = "my";
        String str3 = "232";

        assertThat(Validation.hasNonDigit(str1)).isEqualTo(true);
        assertThat(Validation.hasNonDigit(str2)).isEqualTo(true);
        assertThat(Validation.hasNonDigit(str3)).isEqualTo(false);
    }

    @Test
    void hasSameNumber_모두_다른수인지_판별() {
        String str1 = "123";
        String str2 = "242";
        String str3 = "999";

        assertThat(Validation.hasSameNumber(str1)).isEqualTo(false);
        assertThat(Validation.hasSameNumber(str2)).isEqualTo(true);
        assertThat(Validation.hasSameNumber(str3)).isEqualTo(true);
    }

    @Test
    void validateResetInput_1과2빼면_예외발생() {
        String str1 = "1";
        String str2 = "2";
        String str3 = "";
        String str4 = "424";

        assertDoesNotThrow(() -> {
            Validation.validateResetInput(str1);
        });

        assertDoesNotThrow(() -> {
            Validation.validateResetInput(str2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateResetInput(str3);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateResetInput(str4);
        });
    }
}