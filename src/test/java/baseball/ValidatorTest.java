package baseball;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    private static Validator validator;

    @BeforeAll
    static void init() {
        validator = new Validator();
    }

    @Test
    void 정상_숫자_입력_테스트() {
        String input = "123";

        assertThatNoException().isThrownBy(() -> validator.checkValidNumberInput(input));
    }

    @Test
    void 개수_초과_입력_테스트() {
        String input = "1234";

        assertThatThrownBy(() -> validator.checkValidNumberInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3 자리의 숫자를 입력해주세요.");
    }

    @Test
    void 숫자가_아닌_문자_입력_테스트() {
        String input = "12a";

        assertThatThrownBy(() -> validator.checkValidNumberInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주세요.");
    }

    @Test
    void 범위를_벗어난_숫자_입력_테스트() {
        String input = "012";

        assertThatThrownBy(() -> validator.checkValidNumberInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1-9 사이의 숫자를 입력해주세요.");
    }

    @Test
    void 같은_숫자_입력_테스트() {
        String input = "122";

        assertThatThrownBy(() -> validator.checkValidNumberInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("서로 다른 숫자를 입력해주세요.");
    }

    @Test
    void 정상_재시작_입력_태스트() {
        String input = "1";

        assertThatNoException().isThrownBy(() -> validator.checkValidRestartOrQuitInput(input));
    }

    @Test
    void 정상_종료_입력_테스트() {
        String input = "2";

        assertThatNoException().isThrownBy(() -> validator.checkValidRestartOrQuitInput(input));
    }

    @Test
    void 재시작_종료_외_입력_테스트() {
        String input = "3";

        assertThatThrownBy(() -> validator.checkValidRestartOrQuitInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1,2 중 하나의 수를 입력해주세요.");
    }
}
