package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputCheckTest {

    @Test
    void hasNonDigit_모두_숫자인지_판별() {
        String str1 = "1.2";
        String str2 = "my";
        String str3 = "232";

        assertThat(InputCheck.hasNonDigit(str1)).isEqualTo(true);
        assertThat(InputCheck.hasNonDigit(str2)).isEqualTo(true);
        assertThat(InputCheck.hasNonDigit(str3)).isEqualTo(false);

    }

    @Test
    void hasSameNumber_모두_다른수인지_판별() {
        String str1 = "123";
        String str2 = "242";
        String str3 = "999";

        assertThat(InputCheck.hasNonDigit(str1)).isEqualTo(false);
        assertThat(InputCheck.hasNonDigit(str2)).isEqualTo(true);
        assertThat(InputCheck.hasNonDigit(str3)).isEqualTo(true);
    }
}