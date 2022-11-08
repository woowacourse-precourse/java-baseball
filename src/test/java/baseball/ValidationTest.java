package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidationTest {
    @Test
    void baseballInput_게임규격외_예외발생() {
        String str1 = "290";
        String str2 = "321";
        String str3 = "";
        String str4 = "4213";
        String str5 = "322";

        assertThrows(IllegalArgumentException.class, () -> {
            Validation.baseballInput(str1);
        });

        assertDoesNotThrow(() -> {
            Validation.baseballInput(str2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Validation.baseballInput(str3);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Validation.baseballInput(str4);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Validation.baseballInput(str5);
        });
    }

    @Test
    void hasNotFromOneToNine_모두_0부터9사이인지_판별() {
        String str1 = "1.2";
        String str2 = "my";
        String str3 = "232";
        String str4 = "";
        String str5 = "012";
        String str6 = "901";
        String str7 = "abc";

        assertThat(Validation.hasNotFromOneToNine(str1)).isEqualTo(true);
        assertThat(Validation.hasNotFromOneToNine(str2)).isEqualTo(true);
        assertThat(Validation.hasNotFromOneToNine(str3)).isEqualTo(false);
        assertThat(Validation.hasNotFromOneToNine(str4)).isEqualTo(false);
        assertThat(Validation.hasNotFromOneToNine(str5)).isEqualTo(true);
        assertThat(Validation.hasNotFromOneToNine(str6)).isEqualTo(true);
        assertThat(Validation.hasNotFromOneToNine(str7)).isEqualTo(true);

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
    void resetInput_1과2빼면_예외발생() {
        String str1 = "1";
        String str2 = "2";
        String str3 = "";
        String str4 = "424";

        assertDoesNotThrow(() -> {
            Validation.resultInput(str1);
        });

        assertDoesNotThrow(() -> {
            Validation.resultInput(str2);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Validation.resultInput(str3);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Validation.resultInput(str4);
        });
    }
}