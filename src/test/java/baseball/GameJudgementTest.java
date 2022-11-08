package baseball;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameJudgementTest {
    GameJudgement gameJudgement = new GameJudgement();
    ByteArrayOutputStream outputStream;

    @CsvSource(value = {
            "3 : 6 : 7 : 2 : 4 : 8 : 0",
            "2 : 9 : 8 : 3 : 9 : 7 : 1",
            "1 : 4 : 5 : 1 : 4 : 5 : 2",
            "3 : 9 : 8 : 4 : 9 : 8 : 3",
            "6 : 2 : 1 : 6 : 2 : 1 : 4"
    }, delimiter = ':')
    @ParameterizedTest
    void 랜덤_수와_사용자_입력_수를_비교한다(int randomOne, int randomTwo, int randomThree, int playerOne, int playerTwo, int playerThree, int idx) {
        List<Integer> randomNumbers = new ArrayList<>(Arrays.asList(randomOne, randomTwo, randomThree));
        List<Integer> playerInputNumbers = new ArrayList<>(Arrays.asList(playerOne, playerTwo, playerThree));

        boolean result = gameJudgement.judge(randomNumbers, playerInputNumbers);
        boolean[] expect = {false, false, true, false, true};

        assertThat(result).isEqualTo(expect[idx]);
    }

    @CsvSource(value = {
            "1 : 2 : 2볼 1스트라이크",
            "0 : 3 : 3볼",
            "0 : 0 : 낫싱",
            "3 : 0 : 3스트라이크",
            "2 : 1 : 1볼 2스트라이크"
    }, delimiter = ':')
    @ParameterizedTest
    void 결과를_출력한다(int strike, int ball, String expect) {
        String result = outputStreamTest(strike, ball);

        assertThat(result).isEqualTo(expect);
    }

    private String outputStreamTest(int strike, int ball) {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        gameJudgement.printResult(strike, ball);

        String output = outputStream.toString().trim();

        return output;
    }
}