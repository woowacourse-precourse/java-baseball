package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.user.User;
import baseball.user.UserValidation;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    void 사용자_입력_확인() {
        User user = new User();

        String input = "234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        user.inputNumber();

        assertThat(user.getGameNumber()).isEqualTo(List.of(2,3,4));
    }
}
