package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameExceptionTest {

    GameException gameException = new GameException();

    @Test
    void restart_1_입력() {

        assertThatCode(() -> gameException.restartException(1))
                .doesNotThrowAnyException();
    }

    @Test
    void restart_2_입력() {

        assertThatCode(() -> gameException.restartException(2))
                .doesNotThrowAnyException();
    }

    @Test
    void restart_3_입력() {

        assertThatThrownBy(() -> gameException.restartException(3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 또는 2가 아닙니다.");
    }

    @Test
    void input_정상_입력() {

        assertThatCode(() -> gameException.inputException("123"))
                .doesNotThrowAnyException();
    }

    @Test
    void input_2자리_입력() {

        assertThatThrownBy(() -> gameException.inputException("12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력 값입니다.");
    }

    @Test
    void input_4자리_입력() {

        assertThatThrownBy(() -> gameException.inputException("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력 값입니다.");
    }

    @Test
    void input_0포함_입력() {

        assertThatThrownBy(() -> gameException.inputException("012"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력 값입니다.");
    }

    @Test
    void input_문자_입력() {

        assertThatThrownBy(() -> gameException.inputException("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 입력 값입니다.");
    }

}