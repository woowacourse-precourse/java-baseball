package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {
    private static User user;

    @BeforeEach
    private void createUser() {
        user = new User();
    }

    @Test
    void 유저_숫자_입력_검사() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(user.getInputNumbers()).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void 게임_재개_여부_검사() {
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(user.getNumberToContinueGame()).isEqualTo(2);
    }
}
