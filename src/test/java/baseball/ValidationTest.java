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
            Validation.validateBaseballInput(str1);
        });

        assertDoesNotThrow(() -> {
            Validation.validateBaseballInput(str2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateBaseballInput(str3);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateBaseballInput(str4);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Validation.validateBaseballInput(str5);
        });
    }

    @Test
    void hasNonDigit_모두_숫자인지_판별() {
        String str1 = "1.2";
        String str2 = "my";
        String str3 = "232";
        String str4 = "";

        assertThat(Validation.hasNonDigit(str1)).isEqualTo(true);
        assertThat(Validation.hasNonDigit(str2)).isEqualTo(true);
        assertThat(Validation.hasNonDigit(str3)).isEqualTo(false);
        assertThat(Validation.hasNonDigit(str4)).isEqualTo(false);
    }

    @Test
    void hasSameWord_모두_다른글자인지_판별() {
        String str1 = "1234";
        String str2 = "2421";
        String str3 = "999";
        String str4 = "";

        assertThat(Validation.hasSameWord(str1)).isEqualTo(false);
        assertThat(Validation.hasSameWord(str2)).isEqualTo(true);
        assertThat(Validation.hasSameWord(str3)).isEqualTo(true);
        assertThat(Validation.hasSameWord(str4)).isEqualTo(false);
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