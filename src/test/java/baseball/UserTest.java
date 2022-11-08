package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {
    private User user;

    @BeforeEach
    void 사용자_생성() {
        user = new User();
    }

    @Test
    void 사용자_입력값_설정() {
        user.setUserNumber("123");
        assertEquals(123, user.userNumber);
    }
    @Test
    void 예외_사용자_입력값_글자수_초과() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.setUserNumber("1234");
        });
    }
    @Test
    void 예외_사용자_입력값_문자_입력() {
        User user = new User();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            user.setUserNumber("aaa");
        });
    }

}