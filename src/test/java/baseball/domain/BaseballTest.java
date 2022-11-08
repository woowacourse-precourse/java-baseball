package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class BaseballTest {

    @DisplayName("1 ~ 9 야구 숫자로만 객체 생성 가능")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void instantiate(int number) {
        assertThatNoException().isThrownBy(
                () -> Baseball.of(number)
        );
    }

    @DisplayName("1 ~ 9 범위 밖의 값으로는 객체 생성 실패")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10})
    void fail_instantiate(int number) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> Baseball.of(number)
        );
    }
}
