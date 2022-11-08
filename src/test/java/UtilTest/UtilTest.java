package UtilTest;

import baseball.Util.InputValidator;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UtilTest {
    @Test
    void 세자리이상_입력(){
        boolean result = InputValidator.validate("3210");
        assertThat(result).isEqualTo(false);
    }


}
