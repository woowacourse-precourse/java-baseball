package baseball.service;

import static baseball.view.InputView.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import baseball.view.InputView;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GameProcessorTest {

    private GameProcessor gameProcessor;

    @BeforeEach
    void setUp() {
        gameProcessor = new GameProcessor();
    }


    @ParameterizedTest
    @MethodSource("generateStrikeData")
    @DisplayName("3스트라이크시 false 테스트")
    void treeStrikeTest(List<Integer> computerNumber, List<Integer> userNumber) {
        assertThat(gameProcessor.isThreeStrike(computerNumber, userNumber)).isFalse();
    }

    @ParameterizedTest
    @MethodSource("generateNotStrikeData")
    @DisplayName("3스트라이크 이외에 true 테스트")
    void notTreeStrikeTest(List<Integer> computerNumber, List<Integer> userNumber) {
        assertThat(gameProcessor.isThreeStrike(computerNumber, userNumber)).isTrue();
    }

    public static Stream<Arguments> generateNotStrikeData() {
        return Stream.of(
                of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 4)),
                of(Arrays.asList(1, 2, 3), Arrays.asList(1, 3, 2)),
                of(Arrays.asList(1, 2, 3), Arrays.asList(2, 1, 3)),
                of(Arrays.asList(1, 2, 3), Arrays.asList(3, 1, 2))
        );
    }

    private static Stream<Arguments> generateStrikeData() {
        return Stream.of(
                of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3)),
                of(Arrays.asList(3, 2, 1), Arrays.asList(3, 2, 1))
        );
    }
}
