package baseball.numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class NumbersTest {
    @ValueSource(strings = {"123", "456", "789"})
    @ParameterizedTest
    void 문자를_입력받아_Numbers를_생성한다(String input) {
        assertDoesNotThrow(() -> new Numbers(input));
    }

    @CsvSource(value = {"1:2:3", "4:5:6", "7:8:9"}, delimiter = ':')
    @ParameterizedTest
    void 숫자를_입력받아_Numbers를_생성한다(int first, int second, int third) {
        assertDoesNotThrow(() -> new Numbers(List.of(first, second, third)));
    }

    @ValueSource(strings = {"111", "112", "122", "121", "1", "12", "1234"})
    @ParameterizedTest
    void 중복되는_숫자가_있거나_세자리수가_아니면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> new Numbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @MethodSource("wrongInputs")
    @ParameterizedTest
    void 중복되는_숫자가_있거나_세자리수가_아니면_예외가_발생한다(List<Integer> input) {
        assertThatThrownBy(() -> new Numbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @CsvSource(value = {
            "123 : 231 : 3 : 0 : 0",
            "123 : 123 : 0 : 3 : 0",
            "123 : 456 : 0 : 0 : 3",
            "123 : 145 : 0 : 1 : 2",
            "125 : 127 : 0 : 2 : 1",
            "123 : 451 : 1 : 0 : 2",
            "123 : 234 : 2 : 0 : 1",
            "123 : 321 : 2 : 1 : 0",
            "123 : 135 : 1 : 1 : 1"
    }, delimiter = ':')
    @ParameterizedTest
    void 두_Numbers를_비교해서_결과를_반환한다(String first, String second, int ball, int strike, int miss) {
        Numbers answer = new Numbers(first);
        Numbers numbers = new Numbers(second);
        Map<BallTypes, Integer> expected = result(ball, strike, miss);

        assertThat(answer.compare(numbers)).isEqualTo(expected);
    }

    private Map<BallTypes, Integer> result(int ball, int strike, int miss) {
        Map<BallTypes, Integer> result = new HashMap<>();
        result.put(BallTypes.BALL, ball);
        result.put(BallTypes.STRIKE, strike);
        result.put(BallTypes.MISS, miss);
        return result;
    }

    static Stream<Arguments> wrongInputs() {
        return Stream.of(
                null,
                Arguments.of(Collections.emptyList()),
                Arguments.of(List.of(1, 2)),
                Arguments.of(List.of(1, 2, 2)),
                Arguments.of(List.of(1, 2, 3, 4))
        );
    }
}
