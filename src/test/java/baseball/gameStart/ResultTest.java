package baseball.gameStart;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.domain.Game;
import baseball.utils.Converter;
import baseball.view.SystemMessage;

public class ResultTest {

    private PrintStream standardOut;
    private OutputStream captor;

    @BeforeEach
    protected final void init() {
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    protected final void printOutput() {
        System.setOut(standardOut);
        System.out.println(output());
    }

    protected final String output() {
        return captor.toString().trim();
    }

    @ParameterizedTest
    @ValueSource(strings = {"456", "231", "132", "145", "361", "123"})
    void check_result_test(String input) {
        List<Integer> answer = List.of(1, 2, 3);
        List<String> resultList = List.of("낫싱", "3볼", "2볼 1스트라이크", "1스트라이크", "2볼", "3스트라이크");
        Game game = new Game(answer);
        List<Integer> userAnswer = Converter.toIntegerList(input);
        Map<String, Integer> result = game.getResult(userAnswer);
        String resultMessage = Converter.changeResultMapToString(result);
        SystemMessage.printGameResult(resultMessage);
        Assertions.assertThat(resultList).contains(output());
    }
}
