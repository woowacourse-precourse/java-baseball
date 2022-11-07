package baseball.user;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

public class UserOptionTest {
    private User user = new User();

    @Test
    void 옵션_길이_예외() {
        // given
        String userInput = "12";
        String message = "옵션의 길이는 1이어야 합니다.";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // when, then
        assertThatThrownBy(() -> user.inputOption())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(message);
    }

    @Test
    void 존재하지_않는_옵션() {
        // given
        String userInput = "3";
        String message = "옵션은 1과 2여야 합니다.";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // when, then
        assertThatThrownBy(() -> user.inputOption())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(message);
    }
}
