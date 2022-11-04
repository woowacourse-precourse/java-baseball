package baseball.baseballs;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.Baseballs;
import baseball.Result;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LogicTest {

    private static Stream<Arguments> provideBaseballInputsAndStrikeCounts() {
        return Stream.of(
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
}
