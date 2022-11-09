package baseball.validatioon;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidationTest {

    @Nested
    @DisplayName("isValidNumber 검증")
    class IsValidNumber{
        @Test
        @DisplayName("1~9사이가 아님")
        void 유효범위_아님(){
            boolean validNumber = Validation.isValidNumber(0, List.of(1, 2, 3));
            assertThat(validNumber).isFalse();
        }

        @Test
        @DisplayName("이미 있는 값")
        void 중복값(){
            boolean validNumber = Validation.isValidNumber(1, List.of(1, 2));
            assertThat(validNumber).isFalse();
        }

        @Test
        @DisplayName("참값 검증")
        void 참값(){
            boolean validNumber = Validation.isValidNumber(1, List.of(2, 3));
            assertThat(validNumber).isTrue();
        }
    }

    @Nested
    @DisplayName("validateNumber 검증")
    class ValidateNumber{
        @Test
        @DisplayName("1~9사이가 아님")
        void 유효범위_아님(){
            assertThatThrownBy(() -> Validation.validateNumber(0, List.of(1,2)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("이미 있는 값")
        void 중복값(){
            assertThatThrownBy(() -> Validation.validateNumber(1, List.of(1, 2)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }

    @Nested
    @DisplayName("validateCharIsDigit 검증")
    class ValidateCharIsDigit{
        @Test
        @DisplayName("숫자 아닌 값 입력 - 영어")
        void 영어(){
            assertThatThrownBy(() -> Validation.validateCharIsDigit('C'))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("숫자 아닌 값 입력 - 기호")
        void 기호(){
            assertThatThrownBy(() -> Validation.validateCharIsDigit('.'))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("validateOption 검증")
    class ValidateOption{
        @Test
        @DisplayName("잘못된 옵션")
        void 틀린_옵션(){
            assertThatThrownBy(() -> Validation.validateOption(9))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }

    @Nested
    @DisplayName("validateSize 검증")
    class ValidateSize{
        @Test
        @DisplayName("사이즈(1) 다름")
        void 사이즈_다름(){
            assertThatThrownBy(() -> Validation.validateSize("123",2))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("isRestart 검증")
    class IsRestart{
        @Test
        @DisplayName("restart 아님")
        void restart_아님(){
            assertThat(Validation.isRestart(2)).isFalse();
        }

        @Test
        @DisplayName("restart 맞음")
        void restart_맞음(){
            assertThat(Validation.isRestart(1)).isTrue();
        }
    }



}