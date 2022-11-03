package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest {
    private static Game _game;
    private final int _strike = 0;
    private final int _ball = 1;


    @BeforeAll
    static void initAll() {
        _game = new Game();
        System.setOut(System.out);
        System.setIn(System.in);
    }

    @Test
    void scanIsEnd_테스트() {
        String[] input = {"1", "2"};
        boolean[] expected = {false, true};

        for (int i = 0; i < input.length; ++i) {
            InputStream in = new ByteArrayInputStream(input[i].getBytes());
            System.setIn(in);
            boolean ret = _game.scanIsEnd();

            assertThat(ret).isEqualTo(expected[i]);
        }

        String[] wrongInput = {"112", "111", "", "12", "1", "1234", "a12", "abc"};

        for (int i = 0; i < wrongInput.length; ++i) {
            InputStream in = new ByteArrayInputStream(wrongInput[i].getBytes());
            System.setIn(in);

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> _game.scanIsEnd())
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }
    }

    @Test
    void scanUserValue_테스트() {
        String[] input = {"123", "112", "111", "", "12", "1", "1234", "a12", "abc", "567", "987"};
        int[] expected = {123, -1, -1, -1, -1, -1, -1, -1, -1, 567, 987};

        if (input.length != expected.length) {
            assertThat(true);
        }

        for (int i = 0; i < input.length; ++i) {
            InputStream in = new ByteArrayInputStream(input[i].getBytes());
            System.setIn(in);
            int ret = _game.scanUserValue();
            assertThat(ret).isEqualTo(expected[i]);
        }
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
            Assertions.assertThat(out.toString()).isEqualTo(expected[i]);
        }
    }
}
