package baseball;

import org.junit.jupiter.api.Test;
import baseball.Application;
import static org.assertj.core.api.Assertions.*;

public class unitTest {
    @Test
    void isValid_입력값이_유효하지_않은_경우_길이() {
        boolean result = Application.isValid("1234");
        assertThat(result).isEqualTo(false);
    }

    @Test
    void isValid_입력값이_유효하지_않은_경우_문자() {
        boolean result = Application.isValid("ㄱㄴㄷ");
        assertThat(result).isEqualTo(false);
    }

    @Test
    void isValid_입력값이_유효한_경우() {
        boolean result = Application.isValid("123");
        assertThat(result).isEqualTo(true);
    }


}
