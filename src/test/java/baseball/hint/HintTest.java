package baseball.hint;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static baseball.hint.HintType.*;
import static org.assertj.core.api.Assertions.assertThat;

class HintTest {
    @ParameterizedTest(name = "[{index}] savedHintType = {0} count = {1}")
    @MethodSource("whenCreatedHintThenSuccessDummy")
    @DisplayName("저장된 힌트 조회 성공 테스트")
    void whenFindCreatedHintThenSuccessTest(List<HintType> hintTypes, int count) {
        Hint hint = new Hint(hintTypes);
        int findCount = hint.findCountBy(hintTypes.get(0));
        assertThat(findCount).isEqualTo(count);
    }

    @ParameterizedTest(name = "[{index}] savedHintType = {0}")
    @MethodSource("whenCreatedHintThenSuccessDummy")
    @DisplayName("저장되지 않은 힌트 조회 0 성공 테스트")
    void whenFindUnCreatedHintThenSuccessTest(List<HintType> hintTypes) {
        Hint hint = new Hint(hintTypes);
        List<HintType> findHintTypes = Arrays.stream(values())
                .filter(hintType -> hintType != hintTypes.get(0))
                .collect(Collectors.toUnmodifiableList());
        int findCount = 0;
        findCount += hint.findCountBy(findHintTypes.get(0));
        findCount += hint.findCountBy(findHintTypes.get(1));
        assertThat(findCount).isEqualTo(0);
    }

    @RepeatedTest(100)
    @DisplayName("낫싱 확인 성공 테스트")
    void whenHintNothingThenSuccessTest() {
        Hint hint = new Hint(List.of(NOTHING, NOTHING, NOTHING));
        boolean isNothing = hint.isNothing();
        assertThat(isNothing).isTrue();
    }

    @ParameterizedTest(name = "[{index}] savedHintType = {0}")
    @MethodSource("whenHintNotNothingThenFailDummy")
    @DisplayName("낫싱이 아닐 경우의 확인 성공 테스트")
    void whenHintNotNothingThenFailTest(List<HintType> hintTypes) {
        Hint hint = new Hint(hintTypes);
        boolean isNothing = hint.isNothing();
        assertThat(isNothing).isFalse();
    }

    static Stream<Arguments> whenCreatedHintThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(List.of(STRIKE, STRIKE, STRIKE), 3),
                Arguments.arguments(List.of(STRIKE, STRIKE), 2),
                Arguments.arguments(List.of(STRIKE), 1),
                Arguments.arguments(List.of(BALL, BALL, BALL), 3),
                Arguments.arguments(List.of(BALL, BALL), 2),
                Arguments.arguments(List.of(BALL), 1),
                Arguments.arguments(List.of(NOTHING, NOTHING, NOTHING), 3),
                Arguments.arguments(List.of(NOTHING, NOTHING), 2),
                Arguments.arguments(List.of(NOTHING), 1)
        );
    }

    static Stream<Arguments> whenHintNotNothingThenFailDummy() {
        return Stream.of(
                Arguments.arguments(List.of(NOTHING, STRIKE, NOTHING)),
                Arguments.arguments(List.of(BALL, NOTHING, NOTHING)),
                Arguments.arguments(List.of(NOTHING, BALL, BALL)),
                Arguments.arguments(List.of(BALL, BALL, BALL)),
                Arguments.arguments(List.of(STRIKE, NOTHING)),
                Arguments.arguments(List.of(NOTHING, BALL)),
                Arguments.arguments(List.of(BALL, NOTHING)),
                Arguments.arguments(List.of(STRIKE)),
                Arguments.arguments(List.of(BALL))
        );
    }
}