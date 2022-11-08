package baseball.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.constant.ValidationMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ExceptionHandlerTest {

    @Nested
    @DisplayName("사용자 입력 숫자 예외처리")
    class validateUserNumberOfString {

        @Test
        @DisplayName("\"12\" 입력 -> 예외 발생")
        void 두자리수_입력() {
            String userNumberOfString = "12";
            assertThatThrownBy(() -> ExceptionHandler.validateUserNumberOfString(userNumberOfString))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ValidationMessage.USER_INPUT_NUMBER_RULE_ANNOUNCEMENT);
        }

        @Test
        @DisplayName("\"1234\" 입력 -> 예외 발생")
        void 네자리수_입력() {
            String userNumberOfString = "1234";
            assertThatThrownBy(() -> ExceptionHandler.validateUserNumberOfString(userNumberOfString))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ValidationMessage.USER_INPUT_NUMBER_RULE_ANNOUNCEMENT);
        }

        @Test
        @DisplayName("\"12a\" 입력 -> 예외 발생")
        void 영어_입력() {
            String userNumberOfString = "12a";
            assertThatThrownBy(() -> ExceptionHandler.validateUserNumberOfString(userNumberOfString))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ValidationMessage.USER_INPUT_NUMBER_RULE_ANNOUNCEMENT);
        }

        @Test
        @DisplayName("\"112\" 입력 -> 예외 발생")
        void 중복_숫자_입력() {
            String userNumberOfString = "12a";
            assertThatThrownBy(() -> ExceptionHandler.validateUserNumberOfString(userNumberOfString))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ValidationMessage.USER_INPUT_NUMBER_RULE_ANNOUNCEMENT);
        }
    }

    @Nested
    @DisplayName("게임 반복 여부 숫자 예외처리")
    class validateOneIfGameRepeatOrTwo {

        @Test
        @DisplayName("\"11\" 입력 -> 예외 발생")
        void 두자리수_입력() {
            String oneIfGameRepeatOrTwo = "11";
            assertThatThrownBy(() -> ExceptionHandler.validateOneIfGameRepeatOrTwo(oneIfGameRepeatOrTwo))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ValidationMessage.USER_INPUT_FOR_CHECK_REPEAT_GAME_RULE_ANNOUNCEMENT);
        }

        @Test
        @DisplayName("\"a\" 입력 -> 예외 발생")
        void 영어_입력() {
            String oneIfGameRepeatOrTwo = "a";
            assertThatThrownBy(() -> ExceptionHandler.validateOneIfGameRepeatOrTwo(oneIfGameRepeatOrTwo))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ValidationMessage.USER_INPUT_FOR_CHECK_REPEAT_GAME_RULE_ANNOUNCEMENT);
        }
    }

}
