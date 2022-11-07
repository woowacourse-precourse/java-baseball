package baseball.ui;

import baseball.numbers.BallTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    private OutputStream outputStream;

    @BeforeEach
    protected final void init() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @CsvSource(value = {
            "3 : 0 : 0 : 3볼",
            "0 : 3 : 0 : 3스트라이크",
            "0 : 0 : 3 : 낫싱",
            "0 : 1 : 2 : 1스트라이크",
            "0 : 2 : 1 : 2스트라이크",
            "1 : 0 : 2 : 1볼",
            "2 : 0 : 1 : 2볼",
            "2 : 1 : 0 : 2볼 1스트라이크",
            "1 : 1 : 1 : 1볼 1스트라이크"
    }, delimiter = ':')
    @ParameterizedTest
    void Result를_출력한다(int ball, int strike, int miss, String output) {
        OutputView.printCompareResult(result(ball, strike, miss));

        assertThat(output()).isEqualTo(output);
    }

    private Result result(int ball, int strike, int miss) {
        Map<BallTypes, Integer> result = new HashMap<>();
        result.put(BallTypes.BALL, ball);
        result.put(BallTypes.STRIKE, strike);
        result.put(BallTypes.MISS, miss);
        return new Result(result);
    }

    private String output() {
        return outputStream.toString().trim();
    }
}
