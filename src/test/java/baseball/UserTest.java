package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class UserTest {

    @Test
    void 숫자_입력_테스트() {
        User user = new User();
        user.inputNumber("123");

        assertThat(user.getNumbers().size()).isEqualTo(3);
    }

    @Test
    void 숫자_이외의_문자_입력_예외() {
        assertThatThrownBy(() -> {
            User user = new User();
            user.inputNumber("1*3");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_자리수_예외() {
        assertThatThrownBy(() -> {
            User user = new User();
            user.inputNumber("13");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_0_입력_예외() {
        assertThatThrownBy(() -> {
            User user = new User();
            user.inputNumber("401");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_중복_입력_예외() {
        assertThatThrownBy(() -> {
            User user = new User();
            user.inputNumber("121");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
