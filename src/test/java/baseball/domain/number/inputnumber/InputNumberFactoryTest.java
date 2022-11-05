package baseball.domain.number.inputnumber;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static baseball.domain.number.inputnumber.InputNumberFactory.newInstance;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputNumberFactoryTest {

    @ParameterizedTest(name = "중복_숫자를_입력하면_예외를_던진다")
    @ValueSource(strings = {"112", "111"})
    void 중복_숫자를_입력하면_예외를_던진다(String inputValue) {
        assertThatThrownBy(() -> newInstance(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복 숫자는 입력할 수 없습니다.");
    }

    @ParameterizedTest(name = "세_자리가_아닌_문자열을_입력받으면_예외를_던진다")
    @ValueSource(strings = {"1234", "12"})
    void 세_자리가_아닌_문자열을_입력받으면_예외를_던진다(String inputValue) {
        assertThatThrownBy(() -> newInstance(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("세자리의 숫자를 입력해 주세요.");
    }
}