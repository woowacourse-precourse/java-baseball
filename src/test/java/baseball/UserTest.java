package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class UserTest {
    User user = new User();

    @Test
    void 사용자_수_정상_입력() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        user.input();
        user.exception();

        List<Integer> list = List.of(1, 2, 3);
        assertThat(user.userNumber()).isEqualTo(list);
    }

    @Test
    void 사용자_수_길이_오류() {
        String input = "1234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        user.input();

        assertThatIllegalArgumentException().isThrownBy(() -> user.exception());
    }

    @Test
    void 사용자_수_0_포함() {
        String input = "104";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        user.input();

        assertThatIllegalArgumentException().isThrownBy(() -> user.exception());
    }

    @Test
    void 사용자_수_중복() {
        String input = "144";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        user.input();

        assertThatIllegalArgumentException().isThrownBy(() -> user.exception());
    }
}
