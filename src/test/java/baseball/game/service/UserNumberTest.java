package baseball.game.service;

import baseball.game.constants.Exception;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class UserNumberTest {

    @Test
    void 정상_입력 () {
        String userNumber = "123";

        assertThat(UserNumber.generate(userNumber)).isEqualTo(Arrays.asList(1,2,3));
    }

    @Test
    void 세자리_아닌_경우 () {
        String userNumber = "1234";

        assertThatThrownBy(() -> UserNumber.generate(userNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Exception.NO_THREE_LENGTH);
    }

    @Test
    void 숫자_아닌_경우 () {
        String userNumber = "가12";

        assertThatThrownBy(() -> UserNumber.generate(userNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Exception.NO_NUMBER);
    }

    @Test
    void 중복된_숫자_있는_경우 () {
        String userNumber = "112";

        assertThatThrownBy(() -> UserNumber.generate(userNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Exception.DUPLICATE_NUMBER);
    }

}