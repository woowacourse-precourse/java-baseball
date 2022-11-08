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

    @Test
    void 스트라이크_증가_테스트() {
        User user = new User();
        user.inputNumber("123");

        user.addStrike();

        assertThat(user.getStrike()).isEqualTo(1);
    }

    @Test
    void 볼_증가_테스트() {
        User user = new User();
        user.inputNumber("123");

        user.addBall();

        assertThat(user.getBall()).isEqualTo(1);
    }

    @Test
    void 정답시_종료_변환_테스트() {
        User user = new User();
        user.inputNumber("123");

        user.correctAnswer();

        assertThat(user.isEnd()).isTrue();
    }

    @Test
    void 리셋_정답_초기화_테스트() {
        User user = new User();
        user.inputNumber("123");

        user.reset();

        assertThat(user.getAnswers()).isEmpty();
    }

    @Test
    void 리셋_종료_초기화_테스트() {
        User user = new User();
        user.inputNumber("123");

        user.reset();

        assertThat(user.isEnd()).isFalse();
    }
}
