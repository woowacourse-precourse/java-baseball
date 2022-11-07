package baseball.baseballs;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.game.Result;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LogicTest {

    private static Stream<Arguments> provideBaseballInputsAndStrikeCounts() {
        return Stream.of(
                //answerInput, userInput, strikeCounts
                Arguments.of(String.valueOf(123), String.valueOf(123), 3),
                Arguments.of(String.valueOf(123), String.valueOf(124), 2),
                Arguments.of(String.valueOf(123), String.valueOf(189), 1),
                Arguments.of(String.valueOf(123), String.valueOf(983), 1),
                Arguments.of(String.valueOf(123), String.valueOf(923), 2),
                Arguments.of(String.valueOf(123), String.valueOf(321), 1),
                Arguments.of(String.valueOf(123), String.valueOf(567), 0),
                Arguments.of(String.valueOf(123), String.valueOf(312), 0)
        );
    }

    private static Stream<Arguments> provideBaseballInputsAndBallCounts() {
        return Stream.of(
                //answerInput, userInput, ballCounts
                Arguments.of(String.valueOf(123), String.valueOf(123), 0),
                Arguments.of(String.valueOf(456), String.valueOf(456), 0),
                Arguments.of(String.valueOf(123), String.valueOf(189), 0),
                Arguments.of(String.valueOf(123), String.valueOf(412), 2),
                Arguments.of(String.valueOf(123), String.valueOf(312), 3),
                Arguments.of(String.valueOf(159), String.valueOf(561), 2),
                Arguments.of(String.valueOf(159), String.valueOf(923), 1),
                Arguments.of(String.valueOf(159), String.valueOf(921), 2),
                Arguments.of(String.valueOf(237), String.valueOf(372), 3)
        );
    }

    private static Stream<Arguments> provideBaseballInputsAndNothing() {
        return Stream.of(
                //answerInput, userInput, nothing
                Arguments.of(String.valueOf(123), String.valueOf(789), 0),
                Arguments.of(String.valueOf(456), String.valueOf(123), 0),
                Arguments.of(String.valueOf(123), String.valueOf(546), 0),
                Arguments.of(String.valueOf(138), String.valueOf(925), 0),
                Arguments.of(String.valueOf(231), String.valueOf(698), 0)
        );
    }

    @ParameterizedTest
    @DisplayName("같은 위치에서 값이 일치하는 경우 스트라이크")
    @MethodSource("provideBaseballInputsAndStrikeCounts")
    public void test1(String answerInput, String userInput, int strikeCount) throws Exception{
        //given
        Baseballs answerBaseballs = Baseballs.of(answerInput);
        Baseballs userBaseballs = Baseballs.of(userInput);
        //when
        Result result = answerBaseballs.calculateResult(userBaseballs);
        //then
        assertThat(result).isInstanceOf(Result.class);
        assertThat(result.countStrike()).isEqualTo(strikeCount);
    }

    @ParameterizedTest
    @DisplayName("다른 위치에서 값이 일치하는 경우 볼")
    @MethodSource("provideBaseballInputsAndBallCounts")
    public void test2(String answerInput, String userInput, int ballCount) throws Exception{
        //given
        Baseballs answerBaseballs = Baseballs.of(answerInput);
        Baseballs userBaseballs = Baseballs.of(userInput);
        //when
        Result result = answerBaseballs.calculateResult(userBaseballs);
        //then
        assertThat(result).isInstanceOf(Result.class);
        assertThat(result.countBall()).isEqualTo(ballCount);
    }

    @ParameterizedTest
    @DisplayName("볼과 스트라이크가 없는 경우 낫싱")
    @MethodSource("provideBaseballInputsAndNothing")
    public void test3(String answerInput, String userInput, int nothing) throws Exception{
        //given
        Baseballs answerBaseballs = Baseballs.of(answerInput);
        Baseballs userBaseballs = Baseballs.of(userInput);
        //when
        Result result = answerBaseballs.calculateResult(userBaseballs);
        //then
        assertThat(result).isInstanceOf(Result.class);
        assertThat(result.countBall()+result.countStrike()).isEqualTo(nothing);
    }
}
