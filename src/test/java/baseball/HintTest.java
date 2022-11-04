package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HintTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @AfterEach
    void resetOutputStream() {
        System.setOut(System.out);
        output.reset();
    }

    @Test
    void judge_result_case1() {
        List<Integer> userInput = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> randomNum = new ArrayList<>(Arrays.asList(4, 5, 6));
        List<Integer> result = new ArrayList<>(Arrays.asList(0, 0));

        Game game = new Game();
        game.setRandomNum(randomNum);

        assertThat(Hint.result(userInput, game)).isEqualTo(result);
    }

    @Test
    void judge_result_case2() {
        List<Integer> userInput = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> randomNum = new ArrayList<>(Arrays.asList(1, 3, 6));
        List<Integer> result = new ArrayList<>(Arrays.asList(1, 1));

        Game game = new Game();
        game.setRandomNum(randomNum);

        assertThat(Hint.result(userInput, game)).isEqualTo(result);
    }

    @Test
    void judge_result_case3() {
        List<Integer> userInput = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> randomNum = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> result = new ArrayList<>(Arrays.asList(0, 3));

        Game game = new Game();
        game.setRandomNum(randomNum);

        assertThat(Hint.result(userInput, game)).isEqualTo(result);
    }

    @Test
    void print_judge_result() {
        List<Integer> userInput = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> randomNum = new ArrayList<>(Arrays.asList(1, 3, 2));
        String result = "2볼 1스트라이크";

        Game game = new Game();
        game.setRandomNum(randomNum);

        System.setOut(new PrintStream(output));

        Hint.printResult(Hint.result(userInput, game));

        assertThat(output.toString().trim())
                .contains(result);
    }
}
