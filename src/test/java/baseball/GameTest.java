package baseball;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    void init() {
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    void printHint_테스트() {
        int[][] roundResults = {{1, 1}, {0, 0}, {3, 0}, {2, 0}, {0, 3}, {2, 1}};
        String[] expected = {"1볼 1스트라이크\n", "낫싱\n", "3스트라이크\n", "2스트라이크\n", "3볼\n", "1볼 2스트라이크\n"};

        for (int i = 0; i < roundResults.length; ++i) {
            List<Integer> roundResult = Arrays.asList(roundResults[i][_strike], roundResults[i][_ball]);
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            _game.printHint(roundResult);
            Assertions.assertThat(out.toString()).isEqualTo(expected[i]);
        }
    }

    @Test
    void isGameEnd_테스트() {
        int[][] input = {{0, 3}, {0, 2}, {0, 1}, {3, 0}, {2, 1}, {1, 1}, {0, 0}};
        boolean[] expected = {true, false, false, false, false, false, false};

        for (int i = 0; i < input.length; ++i) {
            List<Integer> list = new ArrayList<>();
            list.add(input[i][_ball]);
            list.add(input[i][_strike]);
            Assertions.assertThat(_game.isGameEnd(list)).isEqualTo(expected[i]);
        }
    }

    @Test
    void getResult_테스트() {
        int opponentValue = 123;
        int[] userValue = {145, 124, 123, 425, 423, 453, 567, 321};
        int[][] expected = {{0, 1}, {0, 2}, {0, 3}, {0, 1}, {0, 2}, {0, 1}, {0, 0}, {2, 1}};

        for (int i = 0; i < userValue.length; ++i) {
            List<Integer> result = _game.getResult(splitDigits(userValue[i]), splitDigits(opponentValue));

            assertThat(result.get(_strike)).isEqualTo(expected[i][_strike]);
            assertThat(result.get(_ball)).isEqualTo(expected[i][_ball]);
        }
    }

    private List<Integer> splitDigits(int input) {
        List<Integer> digits = new ArrayList<>();
        int front = input / 100;
        int middle = (input % 100) / 10;
        int rear = input % 10;

        digits.add(front);
        digits.add(middle);
        digits.add(rear);

        return digits;
    }

    @Test
    void generateRandomValue_테스트() {
        for (int i = 0; i < 300; ++i) {
            List<Integer> value = _game.generateRandomValue();

            assertThat(isDuplicatedDigits(value)).isEqualTo(false);
        }
    }

    private boolean isDuplicatedDigits(List<Integer> digits) {
        if (digits.size() != 3
                || (digits.get(0) < 1 || digits.get(0) > 9)
                || (digits.get(1) < 1 || digits.get(1) > 9)
                || (digits.get(2) < 1 || digits.get(2) > 9)
                || digits.get(0) == digits.get(1)
                || digits.get(1) == digits.get(2)
                || digits.get(2) == digits.get(0)) {
            return true;
        }
        return false;
    }

    @Test
    void readIsQuit_정상적인_입력() {
        String[] input = {"1", "2"};
        boolean[] expected = {false, true};

        for (int i = 0; i < input.length; ++i) {
            InputStream in = new ByteArrayInputStream(input[i].getBytes());
            System.setIn(in);

            assertThat(_game.readIsQuit()).isEqualTo(expected[i]);
        }
    }

    @Test
    void readInputForGame_정상적인_입력() {
        String[] input = {"123", "234", "987", "567", "159", "184"};
        int[][] expected = {{1, 2, 3}, {2, 3, 4}, {9, 8, 7}, {5, 6, 7}, {1, 5, 9}, {1, 8, 4}};
        List<Integer> result, expectedList;

        for (int i = 0; i < input.length; ++i) {
            InputStream in = new ByteArrayInputStream(input[i].getBytes());
            System.setIn(in);

            result = _game.readInputForGame();
            expectedList = new ArrayList<>();

            expectedList.add(expected[i][0]);
            expectedList.add(expected[i][1]);
            expectedList.add(expected[i][2]);

            assertThat(result).isEqualTo(expectedList);
        }
    }

    @Test
    void readIsQuit_비_정상적인_입력() {
        String[] input = {"3", "4", "0", "-1", "a", "", ""};
        boolean isThrown;

        for (int i = 0; i < input.length; ++i) {
            isThrown = false;
            InputStream in = new ByteArrayInputStream(input[i].getBytes());
            System.setIn(in);

            try {
                _game.readIsQuit();
            } catch (IllegalArgumentException ex) {
                isThrown = true;
            }
            if (isThrown == false) {
                assertThat("IllegalArgumentException was not Thrown").isEqualTo("IllegalArgumentException");
            }
        }
    }
}
