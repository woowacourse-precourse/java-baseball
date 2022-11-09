package baseball.io;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class UserInputTest {

    @DisplayName("사용자가 올바른 입력에 성공한다")
    @Test
    void 사용자에게_입력받은_숫자가_올바를_경우() {
        // given

        // when & then
        assertAll(
                () -> assertThatCode(() -> new UserInput("123"))
                        .doesNotThrowAnyException(),
                () -> assertThatCode(() -> new UserInput("521"))
                        .doesNotThrowAnyException(),
                () -> assertThatCode(() -> new UserInput("547"))
                        .doesNotThrowAnyException()
        );
    }

    @DisplayName("사용자가 올바르지 못한 입력으로 실패한다.")
    @Test
    void 사용자에게_입력받은_숫자가_올바르지_못할_경우() {
        // given

        // when & then
        assertAll(
                () -> assertThatThrownBy(() -> new UserInput("113"))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new UserInput("103"))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new UserInput("4e1"))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new UserInput("erq"))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new UserInput("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}