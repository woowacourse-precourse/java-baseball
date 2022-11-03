package baseball;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class GameTest {
    private Game _game = new Game();
    private static final int _ball = 0;
    private static final int _strike = 1;
    @Test
    void printHint_테스트() {
        int[][] roundResults = {{1, 1}, {0, 0}, {3, 0}, {2, 0}, {0, 3}, {2, 1}};
        String[] expected = {"1볼 1스트라이크\n", "낫싱\n", "3스트라이크\n", "2스트라이크\n", "3볼\n", "1볼 2스트라이크\n"};

        if (roundResults.length != expected.length) {
            assertThat(true);
        }

        for (int i = 0; i < roundResults.length; ++i) {
            List<Integer> roundResult
                    = Arrays.asList(roundResults[i][_strike], roundResults[i][_ball]);
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            _game.printHint(roundResult);
            Assertions.assertThat(out.toString()).isEqualTo(expected[i]);
        }
    }
}
