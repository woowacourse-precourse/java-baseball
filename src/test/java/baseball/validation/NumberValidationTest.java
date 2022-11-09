package baseball.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("예외처리 테스트")
class NumberValidationTest {

    NumberValidation validation = new NumberValidation();

    @Nested
    @DisplayName("글자 길이에 대한 예외처리")
    class validateLength {
        @Test
        @DisplayName("네글자 입력")
        void case1() {
            String userInput = "1234";
            assertThrows(IllegalArgumentException.class, () -> {
                validation.validateLength(userInput);
            });
        }

        @Test
        @DisplayName("두글자 입력")
        void case2() {
            String userInput = "34";
            assertThrows(IllegalArgumentException.class, () -> {
                validation.validateLength(userInput);
            });
        }

        @Test
        @DisplayName("한글자 입력")
        void case3() {
            String userInput = "34";
            assertThrows(IllegalArgumentException.class, () -> {
                validation.validateLength(userInput);
            });
        }
    }

    @Nested
    @DisplayName("숫자인지 검증")
    class validateIsNumber {
        @Test
        @DisplayName("알파벳의 경우")
        void case1() {
            String userInput = "abc";
            assertThrows(IllegalArgumentException.class, () -> {
                validation.validateIsNumber(userInput);
            });
        }

        @Test
        @DisplayName("한글의 경우")
        void case2() {
            String userInput = "홍길동";
            assertThrows(IllegalArgumentException.class, () -> {
                validation.validateIsNumber(userInput);
            });
        }

        @Test
        @DisplayName("알파벳과 한글의 경우")
        void case3() {
            String userInput = "안녕하세요 junho 입니다";
            assertThrows(IllegalArgumentException.class, () -> {
                validation.validateIsNumber(userInput);
            });
        }
    }

    @Nested
    @DisplayName("숫자의 중복을 검증")
    class validateDuplicate {
        @Test
        @DisplayName("두글자 중복")
        void case1() {
            String userInput = "113";
            assertThrows(IllegalArgumentException.class, () -> {
                validation.validateDuplicate(userInput);
            });
        }

        @Test
        @DisplayName("세글자 중복")
        void case2() {
            String userInput = "111";
            assertThrows(IllegalArgumentException.class, () -> {
                validation.validateDuplicate(userInput);
            });
        }

        @Test
        @DisplayName("다섯글자 중복")
        void case3() {
            String userInput = "11111";
            assertThrows(IllegalArgumentException.class, () -> {
                validation.validateDuplicate(userInput);
            });
        }
    }


}