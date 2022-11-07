package baseball.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class NumberValidatorTest {

    @Test
    void 숫자_크기가_다른_경우_예외_발생() {
        String checkNumber = "1234";

        assertThatThrownBy(() -> NumberValidator.checkSize(checkNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력 숫자의 크기(길이)를 확인하세요.");
    }

    @Test
    void 중복된_숫자가_있는_경우_예외_발생() {
        String checkNumber = "112";

        assertThatThrownBy(() -> NumberValidator.checkUnique(checkNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("각 자리수는 중복을 허락하지 않습니다.");
    }

    @Test
    void 숫자_범위가_조건에_맞지않는_경우_예외_발생1() {
        String checkNumber = "102";

        assertThatThrownBy(() -> NumberValidator.checkNumberCondition(checkNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~9 까지의 수 조건에 충족하지 않습니다.");
    }

    @Test
    void 숫자_범위가_조건에_맞지않는_경우_예외_발생2() {
        String checkNumber = "1 0";

        assertThatThrownBy(() -> NumberValidator.checkNumberCondition(checkNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~9 까지의 수 조건에 충족하지 않습니다.");
    }

    @Test
    void 숫자_범위가_조건에_맞지않는_경우_예외_발생3() {
        String checkNumber = "abc";

        assertThatThrownBy(() -> NumberValidator.checkNumberCondition(checkNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~9 까지의 수 조건에 충족하지 않습니다.");
    }

    @Test
    void 숫자_범위가_조건에_맞지않는_경우_예외_발생4() {
        String checkNumber = "ac#";

        assertThatThrownBy(() -> NumberValidator.checkNumberCondition(checkNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1~9 까지의 수 조건에 충족하지 않습니다.");
    }

    @Test
    void 재시작_입력이_조건에_맞지않는_경우_예외_발생1() {
        String checkNumber = "a";

        assertThatThrownBy(() -> NumberValidator.checkRetryNumber(checkNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 재시작 여부는 1또는 2 숫자만 가능합니다.");
    }

    @Test
    void 재시작_입력이_조건에_맞지않는_경우_예외_발생2() {
        String checkNumber = "@";

        assertThatThrownBy(() -> NumberValidator.checkRetryNumber(checkNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 재시작 여부는 1또는 2 숫자만 가능합니다.");
    }

    @Test
    void 재시작_입력이_조건에_맞지않는_경우_예외_발생3() {
        String checkNumber = "";

        assertThatThrownBy(() -> NumberValidator.checkRetryNumber(checkNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 재시작 여부는 1또는 2 숫자만 가능합니다.");
    }

    @Test
    void 재시작_입력이_조건에_맞지않는_경우_예외_발생4() {
        String checkNumber = "1234";

        assertThatThrownBy(() -> NumberValidator.checkRetryNumber(checkNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임 재시작 여부는 1또는 2 숫자만 가능합니다.");
    }

}