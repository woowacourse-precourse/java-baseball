package baseball.overlap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OverlapTest {

    @DisplayName("중복된 값 찾기")
    @ParameterizedTest
    @ValueSource(strings = {"111", "222", "333"})
    void 중복_값_찾기(String no) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new BaseballNumber(no))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("중복된 수 발견.");
    }

    @DisplayName("입력값의 범위 오류 찾기")
    @ParameterizedTest
    @ValueSource(strings = {"1", "22", "4444", "125125134", " "})
    void 입력값_범위_오류_찾기(String no) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new BaseballNumber(no))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("지정 범위를 벗어났습니다.");
    }
    
    @DisplayName("잘못된 입력값")
    @ParameterizedTest
    @ValueSource(strings = {"안녕", "asd2", "vfs"})
    void 잘못된_입력값_찾기(String no) {
        // given
        // when
        // then
        assertThatThrownBy(() -> new BaseballNumber(no))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("잘못된 입력입니다.");
    }
}
