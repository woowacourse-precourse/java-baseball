package baseball.Util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CheckUtilTest {
    @Test
    void lengthCheck_길이가_3인지_체크() {
        assertThatThrownBy(() -> CheckUtil.lengthCheck("1423", Constant.MAX_LENGTH))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isDuplicate_중복된_값이__있는지_체크() {
        assertThatThrownBy(() -> CheckUtil.isDuplicate("122"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isInteger_입력값이_숫자인지_체크() {
        assertThatThrownBy(() -> CheckUtil.isInteger("12#"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}