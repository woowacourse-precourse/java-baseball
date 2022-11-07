package baseball;

import static baseball.utils.ErrorMessages.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {
    @DisplayName("from 메소드")
    @Nested
    class FromTest {
        @DisplayName("입력값이 세 자리가 아닌 경우 예외 발생")
        @Nested
        class TreeDigitNumber {
            @ParameterizedTest(name = "입력값={0}")
            @ValueSource(ints = {1, 12, 1234})
            void from_메소드의_입력값이_세_자리가_아닌_경우_예외_발생(int number) {
                Assertions.assertThatIllegalArgumentException()
                        .isThrownBy(() -> Player.from(number))
                        .withMessage(REQUIRE_THREE_DIGIT_NUMBER);
            }
        }

        @DisplayName("입력값이 1에서 9 사이의 숫자로 이루어지지 않은 경우 예외 발생")
        @Nested
        class BetweenOneAndNine {
            @ParameterizedTest(name = "입력값={0}")
            @ValueSource(ints = {120, 103, -10})
            void from_메소드의_입력값이_1에서_9_사이의_숫자로_이루어지지_않은_경우_예외_발생(int number) {
                Assertions.assertThatIllegalArgumentException()
                        .isThrownBy(() -> Player.from(number))
                        .withMessage(BETWEEN_ONE_AND_NINE);
            }
        }

        @DisplayName("입력값에 중복된 숫자가 있으면 예외 발생")
        @Nested
        class DuplicateNumber {
            @ParameterizedTest(name = "입력값={0}")
            @ValueSource(ints = {111, 121, 344})
            void from_메소드의_입력값에_중복된_숫자가_있으면_예외_발생(int number) {
                Assertions.assertThatIllegalArgumentException()
                        .isThrownBy(() -> Player.from(number))
                        .withMessage(DUPLICATE_NUMBER);
            }
        }
    }
}
