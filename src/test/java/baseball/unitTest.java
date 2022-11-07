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

    @Test
    void randomGenerator_유효성_검증() {
        String randomString = Application.randomGenerator();
        boolean result = Application.isValid(randomString);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void is3Strike_유효성_검증_숫자가_다른_경우() {
        boolean result = Application.is3Strike("123", "234");
        assertThat(result).isEqualTo(false);
    }

    @Test
    void is3Strike_유효성_검증_숫자가_같은_경우() {
        boolean result = Application.is3Strike("234", "234");
        assertThat(result).isEqualTo(true);
    }
}
