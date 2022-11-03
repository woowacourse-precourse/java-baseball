package baseball.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallHitsTypeResult {
    private static Stream<Arguments> provideInput() {
        return Stream.of(Arguments.of("123", "321", 0, BaseBallHitsType.BALL),
                Arguments.of("123", "321", 1, BaseBallHitsType.STRIKE),
                Arguments.of("123", "321", 2, BaseBallHitsType.BALL));
    }

    @ParameterizedTest
    @MethodSource("provideInput")
    void findBallResultType(String homeRun, String hits, int index, BaseBallHitsType baseBallHitsType) {
        BaseBallHitsType ballResultType = BaseBallHitsType.findBallType(homeRun, hits, index);
        assertThat(ballResultType).isEqualTo(baseBallHitsType);
    }
}