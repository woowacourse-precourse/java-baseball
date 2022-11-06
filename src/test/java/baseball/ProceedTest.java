package baseball;

import baseball.Utils.NumberListComparator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProceedTest {
    static NumberListComparator comparator;
    static ByteArrayOutputStream consoleOutput;

    @BeforeAll
    private static void initClasses() {
        comparator = new NumberListComparator();

        consoleOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(consoleOutput));
    }

    @Test
    void 결과메세지_테스트() {
        List<Integer> answer = List.of(1, 2, 3);
        comparator.setAnswerNumberListForComparing(answer);
        List<Integer> input;

        List<List<Integer>> inputList = List.of(
                List.of(1, 2, 9),
                List.of(3, 1, 2),
                List.of(1, 3, 2),
                List.of(4, 5, 6)
        );
        String[] expectedOutput = new String[]{
                "2스트라이크\n",
                "3볼\n",
                "2볼 1스트라이크\n",
                "낫싱\n"
        };

        for (int i = 0; i < 4; i++) {
            input = inputList.get(i);

            consoleOutput.reset();
            comparator.compareUserNumbersAndAnswer(input);

            assertThat(consoleOutput.toString()).isEqualTo(expectedOutput[i]);
        }

    }

}
