package baseball.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class SelectedNumberForRestartDTOTest {
    @DisplayName("예외 처리 : null 또는 \"\" 입력 시")
    @ParameterizedTest(name = "{displayName} => {0}")
    @NullAndEmptySource
    void null_or_empty_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new SelectedNumberForRestartDTO(input))
                .withMessage("Null 또는 Empty 를 입력할 수 없습니다.");
    }
}