package baseball.hint;

import baseball.baesball.Baseball;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class HintGeneratorTest {
    private final HintGenerator hintGenerator = new HintGenerator();

    @ParameterizedTest(name = "[{index}] computer = {0}, player = {1}")
    @MethodSource("whenGenerateHintThenSuccessDummy")
    @DisplayName("컴퓨터, 게임 플레이어 게임 진행시 힌트 생성 성공 테스트")
    void whenGenerateHintThenSuccessTest(List<Integer> computerBalls, List<Integer> playerBalls) {
        Baseball computer = new Baseball(computerBalls);
        Baseball player = new Baseball(playerBalls);
        Hint generatedHint = hintGenerator.generate(computer, player);
        assertThat(generatedHint).isNotNull();
    }

    static Stream<Arguments> whenGenerateHintThenSuccessDummy() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3), List.of(1, 2, 3)),
                Arguments.arguments(List.of(4, 2, 3), List.of(1, 2, 3)),
                Arguments.arguments(List.of(1, 5, 3), List.of(2, 7, 3)),
                Arguments.arguments(List.of(6, 1, 3), List.of(1, 2, 3)),
                Arguments.arguments(List.of(8, 7, 1), List.of(8, 3, 7)),
                Arguments.arguments(List.of(4, 7, 3), List.of(1, 5, 3)),
                Arguments.arguments(List.of(6, 2, 3), List.of(2, 1, 3)),
                Arguments.arguments(List.of(2, 5, 3), List.of(1, 6, 3)),
                Arguments.arguments(List.of(7, 4, 1), List.of(9, 3, 7))
        );
    }
}