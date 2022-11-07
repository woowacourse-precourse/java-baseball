package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {

    @Test
    void 사용자_입력이_3자리가_아닐_경우_예외_발생() {
        User user = new User();
        assertThatThrownBy(() -> user.setNumbers("12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력한 수가 3자리가 아닙니다.");
    }

    @Test
    void 사용자_입력값이_범위에_벗어_날_경우_예외_발생() {
        User user = new User();
        assertThatThrownBy(() -> user.setNumbers("012"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력한 수가 1-9가 아닙니다.");
    }

    @Test
    void 사용자_입력에_중복이_있을_경우_예외_발생() {
        User user = new User();
        assertThatThrownBy(() -> user.setNumbers("111"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("서로 다른 수로 이루어진 3자리의 수를 입력해야 합니다.");
    }
}
