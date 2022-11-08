package baseball.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class UserNumbersDTOTest {
    @Test
    @DisplayName("null 또는 empty 가 아니면 올바른 유저 번호 입력 값인지 확인")
    void correct_not_null_or_empty() {
        assertThatNoException()
                .isThrownBy(() -> new UserNumbersDTO("123"));
    }
    
    @DisplayName("예외 처리 : null 또는 empty 입력 시")
    @ParameterizedTest(name = "{displayName} => {0}")
    @NullAndEmptySource
    void blank_exception(String numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new UserNumbersDTO(numbers))
                .withMessage("Null 또는 Empty 를 입력할 수 없습니다.");
    }
}