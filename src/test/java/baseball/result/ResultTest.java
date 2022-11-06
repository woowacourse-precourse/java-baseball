package baseball.result;

import baseball.game.Result;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ResultTest {

    private static Stream<Arguments> ResultsAndAnswers() {
        return Stream.of(
                //Result, answer
                Arguments.of(Result.scoreOf(0,0), "낫싱"),
                Arguments.of(Result.scoreOf(0,1), "1볼"),
                Arguments.of(Result.scoreOf(0,2), "2볼"),
                Arguments.of(Result.scoreOf(0,3), "3볼"),
                Arguments.of(Result.scoreOf(1,0), "1스트라이크"),
                Arguments.of(Result.scoreOf(2,0), "2스트라이크"),
                Arguments.of(Result.scoreOf(1,2), "2볼 1스트라이크"),
                Arguments.of(Result.scoreOf(2,1), "1볼 2스트라이크"),
                Arguments.of(Result.scoreOf(3,0), "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        );
    }

    @ParameterizedTest
    @DisplayName("결과에 대한 올바른 문구 생성 확인")
    @MethodSource("ResultsAndAnswers")
    public void test1(Result result, String expectedMsg) throws Exception{
        //given
        //when
        //then
        Assertions.assertThat(result.toString()).isEqualTo(expectedMsg);
    }
}
