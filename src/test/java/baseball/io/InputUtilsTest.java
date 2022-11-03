package baseball.io;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;

class InputUtilsTest {

    @DisplayName("사용자가 올바른 입력에 성공한다")
    @Test
    void 사용자에게_입력받은_숫자가_올바를_경우() {
        assertAll(
                () -> Assertions.assertThatCode(() -> InputUtils.checkIsValidInput("123"))
                        .doesNotThrowAnyException(),
                () -> Assertions.assertThatCode(() -> InputUtils.checkIsValidInput("521"))
                        .doesNotThrowAnyException(),
                () -> Assertions.assertThatCode(() -> InputUtils.checkIsValidInput("547"))
                        .doesNotThrowAnyException()
        );
    }

    @DisplayName("사용자가 올바르지 못한 입력으로 실패한다.")
    @Test
    void 사용자에게_입력받은_숫자가_올바르지_못할_경우() {
        assertAll(
                () -> Assertions.assertThatThrownBy(() -> InputUtils.checkIsValidInput("113"))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> Assertions.assertThatThrownBy(() -> InputUtils.checkIsValidInput("103"))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> Assertions.assertThatThrownBy(() -> InputUtils.checkIsValidInput("4e1"))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> Assertions.assertThatThrownBy(() -> InputUtils.checkIsValidInput("erq"))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> Assertions.assertThatThrownBy(() -> InputUtils.checkIsValidInput("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}