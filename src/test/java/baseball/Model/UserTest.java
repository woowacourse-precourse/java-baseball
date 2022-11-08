package baseball.Model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UserTest {
    private static User user;

    @BeforeAll
    static void setup() {
        user = new User();
    }

    @Test
    void inputCheck_사용자의_입력값이_올바른지_판단() {
        String[] arr = {"1234#5", "3", "#", "1234", "###"};
        for (String input : arr) {
            assertThatThrownBy(() -> user.inputCheck(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void restartInputCheck_재시작_할때의_입력값이_옳은지_판단() {
        String[] arr = {"123", "3", "#", "1234"};
        for (String input : arr) {
            assertThatThrownBy(() -> user.restartInputCheck(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}