package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public final class BaseballGamePolicyTest {

    @ParameterizedTest
    @MethodSource("ballCases")
    @DisplayName("사용자의 입력이 볼이 나오는 경우 볼을 출력한다")
    public void answerAreBalls(
        final String answer,
        final String guess,
        final String expectedScore
    ) {
        var sut = new BaseballGamePolicy(answer);

        String score = sut.scoreOf(guess);

        assertEquals(expectedScore, score);
    }

    static Stream<Arguments> ballCases() throws Throwable {
        return Stream.of(
            Arguments.of("123", "456", "낫싱"),
            Arguments.of("123", "345", "1볼"),
            Arguments.of("123", "214", "2볼"),
            Arguments.of("123", "312", "3볼")
        );
    }

    @ParameterizedTest
    @MethodSource("strikeCases")
    @DisplayName("사용자의 입력이 스트라이크가 나오는 경우 스트라이크를 출력한다")
    public void answerAreStrikes(
        final String answer,
        final String guess,
        final String expectedScore
    ) {
        var sut = new BaseballGamePolicy(answer);

        String score = sut.scoreOf(guess);

        assertEquals(expectedScore, score);
    }

    static Stream<Arguments> strikeCases() throws Throwable {
        return Stream.of(
            Arguments.of("123", "456", "낫싱"),
            Arguments.of("123", "145", "1스트라이크"),
            Arguments.of("123", "124", "2스트라이크"),
            Arguments.of("123", "123", "3스트라이크")
        );
    }

    @ParameterizedTest
    @MethodSource("ballAndStrikeCases")
    @DisplayName("사용자의 입력이 볼과 스트라이크가 모두 나오는 경우 볼, 스트라이크를 출력한다")
    public void answerAreBallsAndStrikes(
        final String answer,
        final String guess,
        final String expectedScore
    ) {
        var sut = new BaseballGamePolicy(answer);

        String score = sut.scoreOf(guess);

        assertEquals(expectedScore, score);
    }

    static Stream<Arguments> ballAndStrikeCases() throws Throwable {
        return Stream.of(
            Arguments.of("123", "456", "낫싱"),
            Arguments.of("123", "134", "1볼 1스트라이크"),
            Arguments.of("123", "321", "2볼 1스트라이크")
        );
    }
}
