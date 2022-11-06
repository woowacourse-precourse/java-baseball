package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    @Test
    void 사용자_입력이_3자리가_아닐_경우_예외_발생() {
        User user = new User();
        assertThatThrownBy(() -> user.verifyInput("12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력한 수가 3자리가 아닙니다.");
    }

    @Test
    void 사용자_입력이_1부터_9가_아닐_경우_예외_발생() {
        User user = new User();
        assertThatThrownBy(() -> user.verifyInput("120"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력한 수가 1-9가 아닙니다.");
    }
}
