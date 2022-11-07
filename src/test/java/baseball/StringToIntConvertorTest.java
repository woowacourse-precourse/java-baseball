package baseball;

import static baseball.utils.ErrorMessages.CONVERT_STRING_TO_INT_FAIL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import baseball.utils.StringToIntConvertor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringToIntConvertorTest {
    @Test
    void convert_메서드는_문자열을_입력받고_정수를_반환() {
        String input = "123";

        int convertedNumber = StringToIntConvertor.convert(input);

        assertThat(convertedNumber).isEqualTo(123);
    }

    @DisplayName("convert 메서드의 입력값에 숫자로 변환될 수 없는 문자가 입력되면 예외 발생")
    @Nested
    class ConvertFailTest {
        @ParameterizedTest(name = "입력값={0}")
        @ValueSource(strings = {"12a", "aaa", "!@3", "1 3"})
        void convert_메서드_사용_시_입력값에_숫자로_변환될_수_없는_문자가_입력되면_예외_발생(String input) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> StringToIntConvertor.convert(input))
                    .withMessage(CONVERT_STRING_TO_INT_FAIL);
        }
    }
}
