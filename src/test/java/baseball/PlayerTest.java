package baseball;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    @Test
    void 입력값이_3개의_숫자가아니면_예외발생() {
        assertThatThrownBy(() -> new Player(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 3개의 숫자여야 합니다.");
    }

    @MethodSource("createNumberExTestCase")
    @ParameterizedTest
    void 입력값이_같은수가_하나라도_있으면_예외발생(int a, int b, int c) {
        assertThatThrownBy(() -> new Player(List.of(a, b, c)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값은 같은 수가 하나라도 있으면 안됩니다.");
    }

    private static List<Arguments> createNumberExTestCase() {
        return List.of(
                Arguments.of(1, 2, 2),
                Arguments.of(2, 1, 2),
                Arguments.of(2, 2, 1)
        );
    }

}
