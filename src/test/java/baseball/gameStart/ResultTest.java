package baseball.gameStart;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.domain.Game;

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
        String result = game.getResult(input);
        System.out.println(result);
        Assertions.assertThat(resultList).contains(output());
    }
}
