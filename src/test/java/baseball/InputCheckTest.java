package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputCheckTest {

    @Test
    void hasNonDigit_모두_숫자인지_판별_1() {
        String str = "1.2";
        boolean ans = InputCheck.hasNonDigit(str);

        assertThat(ans).isEqualTo(true);
    }

    @Test
    void hasNonDigit_모두_숫자인지_판별_2() {
        String str = "my";
        boolean ans = InputCheck.hasNonDigit(str);

        assertThat(ans).isEqualTo(true);
    }

    @Test
    void hasNonDigit_모두_숫자인지_판별_3() {
        String str = "232";
        boolean ans = InputCheck.hasNonDigit(str);

        assertThat(ans).isEqualTo(false);
    }
}