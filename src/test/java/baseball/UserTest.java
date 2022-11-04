package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.user.User;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

public class UserTest {

    private User user = new User();

    @Test
    void 사용자_입력_확인() {
        // given
        String input = "234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        user.inputNumber();

        // then
        assertThat(user.getGameNumber()).isEqualTo(List.of(2, 3, 4));
    }

    @Test
    void 사용자_숫자이외_작성() {
        // given
        String userInput = "일23";
        String message = "입력은 반드시 숫자여야 합니다.";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // when, then
        assertThatThrownBy(() -> user.inputNumber())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(message);
    }

    @Test
    void 숫자_3자리_확인() {
        // given
        String userInput = "1234";
        String message = "숫자는 반드시 3자리수여야 합니다.";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // when, then
        assertThatThrownBy(() -> user.inputNumber())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(message);
    }

    @Test
    void 각자릿수_범위_확인() {
        // given
        String userInput = "102";
        String message = "각 자릿수는 1 ~ 9여야 합니다.";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        // when, then
        assertThatThrownBy(() -> user.inputNumber())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(message);
    }
}
