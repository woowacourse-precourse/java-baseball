package baseball.validation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestartTest {
    Restart restart = new Restart();
    @Test
    void 길이가_1초과() {
        String input = "12";
        Assertions.assertThat(restart.validate(input))
                .isEqualTo(false);
    }

    @Test
    void 길이가_1미만() {
        String input = "";
        Assertions.assertThat(restart.validate(input))
                .isEqualTo(false);
    }

    @Test
    void 값이_1또는_2가_아닌_경우() {
        String input = "0";
        Assertions.assertThat(restart.validate(input))
                .isEqualTo(false);
    }
}