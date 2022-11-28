package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    @DisplayName("게임 결과를 문자열로 반환한다")
    @ParameterizedTest
    @MethodSource("gameResultMessageTestSource")
    void gameResultMessageTest(int ballCnt, int strikeCnt, String expected) {
        GameResult gameResult = new GameResult(ballCnt, strikeCnt);
        assertThat(gameResult.getMessage()).isEqualTo(expected);
    }

    @DisplayName("3스트라이크이면 참을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1:false", "3:true"}, delimiter = ':')
    void isAllStrikeTest(int strikeCnt, boolean expected) {
        GameResult gameResult = new GameResult(0, strikeCnt);
        assertThat(gameResult.isAllStrike()).isEqualTo(expected);
    }


    private static Stream<Arguments> gameResultMessageTestSource() {
        return Stream.of(
                Arguments.of(0, 0, "낫싱"),
                Arguments.of(1, 0, "1볼"),
                Arguments.of(0, 1, "1스트라이크"),
                Arguments.of(1, 1, "1볼 1스트라이크")
        );
    }
}
