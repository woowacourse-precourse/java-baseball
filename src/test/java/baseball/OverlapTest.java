package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OverlapTest {

    @DisplayName("중복된 수가 있으면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"111", "222", "333"})
    void whenExistDuplicateNumber_thenThrowException(String no) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new BaseballNumber(no))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("중복된 수 발견.");
    }

    @DisplayName("수가 100보다 작고 999보다 클 경우 에러 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1", "22", "4444", "125125134", " "})
    void whenNotThreeNumberLength_thenThrowException(String no) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new BaseballNumber(no))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("잘못된 수 입력.");
    }
    
    @DisplayName("숫자가 아니면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"안녕", "asd2", "vfs"})
    void whenIsNotNumber_thenThrowException(String no) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new BaseballNumber(no))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("잘못된 값을 입력하셨습니다.");
    }
}
