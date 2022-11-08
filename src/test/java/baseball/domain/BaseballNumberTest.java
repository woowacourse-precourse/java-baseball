package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"111", "222", "333"})
    void 중복된_수_찾기(String no) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new BaseballNumber(no))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("잘못된 수를 입력하셨습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "22", "4444", "125125134", " "})
    void 범위를_벗어난_수(String no) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new BaseballNumber(no))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("잘못된 수를 입력하셨습니다.");
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"안녕", "asd2", "vfs"})
    void 수가_아닌_입력(String no) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new BaseballNumber(no))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("잘못된 수를 입력하셨습니다.");
    }
}
