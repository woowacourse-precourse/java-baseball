package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void 사용자의_입력을_저장하기() {
        // given
        User user = new User();
        String input = "123";
        setInput(input);

        // when
        user.inputNumber();

        // then
        Assertions.assertThat(user.getNumber()).isEqualTo(input);
    }

    @Test
    void 입력으로_1이_들어오면_FALSE를_반환한다() {
        // given
        String input = "1";
        setInput(input);
        User user = new User();

        // when
        user.inputNumber();
        boolean result = user.isStop();

        // then
        assertFalse(result);
    }

    @Test
    void 입력으로_2가_들어오면_TRUE를_반환한다() {
        // given
        String input = "2";
        setInput(input);
        User user = new User();

        // when
        user.inputNumber();
        boolean result = user.isStop();

        // then
        assertTrue(result);
    }

    private void setInput(String... inputs) {
        final byte[] buf = String.join("\n", inputs).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

}
