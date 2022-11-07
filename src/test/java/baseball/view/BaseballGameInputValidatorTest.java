package baseball.view;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("입력 유효성 확인")
class BaseballGameInputValidatorTest {

    @Nested
    @DisplayName("사용자 숫자 입력 유효성 검증")
    class NumberInputValidation {
        @DisplayName("길이가 3이 아닌 경우")
        @Test
        public void inputLengthError() {
            // given
            String input = "12";

            // when
            final boolean result = BaseballGameInputValidator.validatePlayerNumber(input);

            // then
            assertFalse(result);
        }

        @DisplayName("같은 값이 있는 경우")
        @Test
        public void sameNumberError() {
            // given
            String input = "112";

            // when
            final boolean result = BaseballGameInputValidator.validatePlayerNumber(input);

            // then
            assertFalse(result);
        }

        @DisplayName("숫자가 아닌 값이 있는 경우")
        @Test
        public void notNumberError() {
            // given
            String input = "1a2";

            // when
            final boolean result = BaseballGameInputValidator.validatePlayerNumber(input);

            // then
            assertFalse(result);
        }

        @DisplayName("올바른 값인 경우")
        @Test
        public void success() {
            // given
            String input = "123";

            // when
            final boolean result = BaseballGameInputValidator.validatePlayerNumber(input);

            // then
            assertTrue(result);
        }
    }

    @Nested
    @DisplayName("재시작 유효성 검증")
    class ReplayInputValidation {

        @DisplayName("잘못된 값인 경우")
        @Test
        public void invalidInput() {
            // given
            String input = "a";

            // when
            final boolean result = BaseballGameInputValidator.validateReplayNumber(input);

            // then
            assertFalse(result);
        }

        @DisplayName("올바른 값인 경우")
        @Test
        public void validInput() {
            // given
            String input = "1";

            // when
            final boolean result = BaseballGameInputValidator.validateReplayNumber(input);

            // then
            assertTrue(result);
        }

    }
}