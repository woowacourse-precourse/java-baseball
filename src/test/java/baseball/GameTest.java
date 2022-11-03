package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    private Game _game;
    private final int _strike = 0;
    private final int _ball = 1;


    @BeforeAll
    void initAll() {
        _game = new Game();
    }

    @Test
    void calcRoundResult_테스트() {
        int opponentValue = 123;
        int[] userValue = {145, 124, 123, 425, 423, 453, 567, 321};
        int[][] expected = {{1, 0}, {2, 0}, {3, 0}, {1, 0}, {2, 0}, {1, 0}, {0, 0}, {0, 3}};

        if (userValue.length != expected.length) {
            assertThat(true);
        }

        for (int i = 0; i < userValue.length; ++i) {
            List<Integer> result = _game.calcRoundResult(userValue[i], opponentValue);

            assertThat(result.get(_strike)).isEqualTo(expected[i][_strike]);
            assertThat(result.get(_ball)).isEqualTo(expected[i][_ball]);
        }
    }

    @Test
    void printHint_테스트() {
        int[][] roundResults = {{1, 1}, {0, 0}, {3, 0}, {2, 0}, {0, 3}, {2, 1}};
        String[] expected = {"1볼 1스트라이크", "낫싱", "3스트라이크", "2스트라이크", "3볼", "1볼 2스트라이크"};

        if (roundResults.length != expected.length) {
            assertThat(true);
        }

        for (int i = 0; i < roundResults.length; ++i) {
            List<Integer> roundResult
                    = Arrays.asList(roundResults[i][_strike], roundResults[i][_ball]);
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            _game.printHint(roundResult);
            Assertions.assertThat(expected[i]).isEqualTo(out.toString());
        }
    }
}
