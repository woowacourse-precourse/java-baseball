package baseball;

import baseball.game.number.Score;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static baseball.game.number.Calculator.scoreCalculator;
import static baseball.userInterface.Output.generateOutput;
import static baseball.userInterface.Output.printScore;
import static org.assertj.core.api.Assertions.assertThat;

public class OutputTest {
    @Test
    void case1() {
        List<Integer> answer = List.of(1,2,3);
        List<Integer> userInput = List.of(1,5,8);
        Score score = scoreCalculator(answer, userInput);

        String output = generateOutput(score);
        assertThat(output).isEqualTo("1스트라이크");
    }

    @Test
    void case2() {
        List<Integer> answer = List.of(1,2,3);
        List<Integer> userInput = List.of(1,2,8);
        Score score = scoreCalculator(answer, userInput);

        String output = generateOutput(score);
        assertThat(output).isEqualTo("2스트라이크");
    }

    @Test
    void case3() {
        List<Integer> answer = List.of(1,2,3);
        List<Integer> userInput = List.of(4,5,7);
        Score score = scoreCalculator(answer, userInput);

        String output = generateOutput(score);
        assertThat(output).isEqualTo("낫싱");
    }

    @Test
    void case4() {
        List<Integer> answer = List.of(1,2,3);
        List<Integer> userInput = List.of(1,3,8);
        Score score = scoreCalculator(answer, userInput);

        String output = generateOutput(score);
        assertThat(output).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void case5() {
        List<Integer> answer = List.of(1,2,3);
        List<Integer> userInput = List.of(1,2,3);
        Score score = scoreCalculator(answer, userInput);

        String output = generateOutput(score);
        assertThat(output).isEqualTo("3스트라이크");
    }

    @Test
    void case6() {
        List<Integer> answer = List.of(1,2,3);
        List<Integer> userInput = List.of(3,1,2);
        Score score = scoreCalculator(answer, userInput);

        String output = generateOutput(score);
        assertThat(output).isEqualTo("3볼");
    }

    @Test
    void case7() {
        List<Integer> answer = List.of(1,2,3);
        List<Integer> userInput = List.of(3,2,1);
        Score score = scoreCalculator(answer, userInput);

        String output = generateOutput(score);
        assertThat(output).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void case8() {
        List<Integer> answer = List.of(1,2,3);
        List<Integer> userInput = List.of(9,2,3);
        Score score = scoreCalculator(answer, userInput);

        String output = generateOutput(score);
        assertThat(output).isEqualTo("2스트라이크");
    }

    @Test
    void case9() {
        List<Integer> answer = List.of(1,2,3);
        List<Integer> userInput = List.of(9,5,1);
        Score score = scoreCalculator(answer, userInput);

        String output = generateOutput(score);
        assertThat(output).isEqualTo("1볼");
    }

    @Test
    void case10() {
        List<Integer> answer = List.of(1,2,3);
        List<Integer> userInput = List.of(2,3,9);
        Score score = scoreCalculator(answer, userInput);

        String output = generateOutput(score);
        assertThat(output).isEqualTo("2볼");
    }
}
