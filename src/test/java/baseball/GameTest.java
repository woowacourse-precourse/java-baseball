package baseball;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;


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

    @Test
    void isGameEnd_테스트() {
        int[][] input = {{0, 3}, {0, 2}, {0, 1}, {3, 0}, {2, 1}, {1, 1}, {0 ,0}};
        boolean[] expected = {true, false, false, false, false, false, false};

        if (input.length != expected.length) {
            assertThat(true);
        }

        for (int i = 0; i < input.length; ++i) {
            List<Integer> list = new ArrayList<>();
            list.add(input[i][_ball]);
            list.add(input[i][_strike]);
            Assertions.assertThat(_game.isGameEnd(list)).isEqualTo(expected[i]);
        }
    }
}
