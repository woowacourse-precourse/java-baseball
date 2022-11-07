package baseball.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

class SelectedNumberForRestartDTOTest {
    private static final String NUMBER_FORM_EXCEPTION_MESSAGE = "1 또는 2만 입력할 수 있습니다.";
    
    @DisplayName("올바른 재시작 선택 번호(1 or 2)인지 확인")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"1", "2"})
    void correct_selected_number_for_restart(String selectedNumberForRestart) {
        assertThatNoException()
                .isThrownBy(() -> new SelectedNumberForRestartDTO(selectedNumberForRestart));
    }
    
    @DisplayName("예외 처리 : null 또는 \"\" 입력 시")
    @ParameterizedTest(name = "{displayName} => {0}")
    @NullAndEmptySource
    void null_or_empty_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new SelectedNumberForRestartDTO(input))
                .withMessage("Null 또는 Empty 를 입력할 수 없습니다.");
    }
    
    @DisplayName("예외 처리 : 알파벳 소문자 및 대문자 입력 시")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"A", "a"})
    void alphabet_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new SelectedNumberForRestartDTO(input))
                .withMessage(NUMBER_FORM_EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("예외 처리 : 특수 문자 입력 시")
    void special_characters_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new SelectedNumberForRestartDTO("$"))
                .withMessage(NUMBER_FORM_EXCEPTION_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 한글 자음, 모음, 단어 입력 시")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"ㄱ", "ㅏ", "가"})
    void korean_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new SelectedNumberForRestartDTO(input))
                .withMessage(NUMBER_FORM_EXCEPTION_MESSAGE);
    }
    
    @Test
    @DisplayName("예외 처리 : 공백 입력 시")
    void space_exception() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new SelectedNumberForRestartDTO(" "))
                .withMessage(NUMBER_FORM_EXCEPTION_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 길이가 1이 아닌 경우")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"12", "123"})
    void length_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new SelectedNumberForRestartDTO(input))
                .withMessage(NUMBER_FORM_EXCEPTION_MESSAGE);
    }
    
    @DisplayName("예외 처리 : 1~2 범위를 벗어난 경우")
    @ParameterizedTest(name = "{displayName} => {0}")
    @ValueSource(strings = {"0", "3"})
    void out_of_range_exception(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new SelectedNumberForRestartDTO(input))
                .withMessage(NUMBER_FORM_EXCEPTION_MESSAGE);
    }
}