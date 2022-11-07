package baseball.ui;

import baseball.numbers.BallTypes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    @CsvSource(value = {"1:2:0:1볼 2스트라이크", "0:1:2:1스트라이크", "1:0:2:1볼", "0:0:3:낫싱"}, delimiter = ':')
    @ParameterizedTest
    void 결과_문자열을_반환한다(int ball, int strike, int nothing, String output) {
        Map<BallTypes, Integer> result = new HashMap<>();
        result.put(BallTypes.BALL, ball);
        result.put(BallTypes.STRIKE, strike);
        result.put(BallTypes.MISS, nothing);

        assertThat(new Result(result).toString()).hasToString(output);
    }
}
