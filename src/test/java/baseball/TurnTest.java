package baseball;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import java.util.List;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

public class TurnTest {
    @Test
    void getPlayerInput_test_getting_input() {
        Turn turn = new Turn();
        String testInput = "234";
        final byte[] buf = testInput.getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThat(turn.getPlayerInput("숫자를 입력해주세요 : ")).isEqualTo(testInput);
    }

    @Test
    void transformPlayerInputToList_test_transforming_input_string_to_list() {
        Turn turn = new Turn();
        String testInput = "123";
        List<Integer> resultOutput = List.of(1, 2, 3);
        assertThat(turn.transformPlayerInputToList(testInput)).isEqualTo(resultOutput);
    }

    @Test
    void validatePlayerNumberList_test_input_length_larger_than_3(){
        Turn turn = new Turn();
        List<Integer> testInput = List.of(1, 2, 3, 4);
        assertThatThrownBy(() -> turn.validatePlayerNumberList(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3개의 숫자만 입력해주세요.");
    }

    @Test
    void validatePlayerNumberList_test_input_length_smaller_than_3(){
        Turn turn = new Turn();
        List<Integer> testInput = List.of(1, 2);
        assertThatThrownBy(() -> turn.validatePlayerNumberList(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3개의 숫자만 입력해주세요.");
    }

    @Test
    void validatePlayerNumberList_test_input_including_non_number_character(){
        Turn turn = new Turn();
        List<Integer> testInput = List.of(33, 42, 55);
        assertThatThrownBy(() -> turn.validatePlayerNumberList(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1에서 9까지의 숫자만 입력해 주세요.");
    }

    @Test
    void validatePlayerNumberList_test_input_including_redundant_numbers(){
        Turn turn = new Turn();
        List<Integer> testInput = List.of(1, 1, 2);
        assertThatThrownBy(() -> turn.validatePlayerNumberList(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("서로 다른 숫자만 입력해주세요.");
    }

    @Test
    void countNumberOfStrikes_test_strike_count() {
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);
        List<Integer> testPlayerNumberList = List.of(2, 4, 5);
        Turn turn = new Turn();
        assertThat(turn.countNumberOfStrikes(testPlayerNumberList, testHiddenNumberList))
                .isEqualTo(2);
    }

    @Test
    void countNumberOfBalls_test_ball_count() {
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);
        List<Integer> testPlayerNumberList = List.of(3, 4, 2);
        Turn turn = new Turn();
        assertThat(turn.countNumberOfBalls(testPlayerNumberList, testHiddenNumberList))
                .isEqualTo(2);
    }

    @Test
    void printResult_test_print_result_1ball_1strike() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Turn turn = new Turn();
        turn.printResult(1, 1);

        String resultOutput = "1볼 1스트라이크\r\n";
        assertThat(out.toString()).isEqualTo(resultOutput);
    }

    @Test
    void printResult_test_print_result_0ball_3strike() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Turn turn = new Turn();
        turn.printResult(0, 3);

        String resultOutput = "3스트라이크\r\n";
        assertThat(out.toString()).isEqualTo(resultOutput);
    }

    @Test
    void printResult_test_print_result_3ball() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Turn turn = new Turn();
        turn.printResult(3, 0);

        String resultOutput = "3볼\r\n";
        assertThat(out.toString()).isEqualTo(resultOutput);
    }

    @Test
    void printResult_test_print_result_nothing() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Turn turn = new Turn();
        turn.printResult(0, 0);

        String resultOutput = "낫싱\r\n";
        assertThat(out.toString()).isEqualTo(resultOutput);
    }

    @Test
    void getStrikeResultString_test_strike_result() {
        Turn turn = new Turn();

        String resultOutput = "2스트라이크";

        assertThat(turn.getStrikeResultString(2)).isEqualTo(resultOutput);
    }

    @Test
    void getBallResultString_test_ball_result() {
        Turn turn = new Turn();

        String resultOutput = "1볼";

        assertThat(turn.getBallResultString(1)).isEqualTo(resultOutput);
    }

    /*@Test
    void isStrikeOut_test_strike_out() {
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);
        List<Integer> testPlayerNumberList = List.of(2, 3, 5);
        Turn turn = new Turn();

        turn.countNumberOfStrikes(testPlayerNumberList, testHiddenNumberList);

        boolean result = true;

        assertThat(turn.isStrikeOut()).isEqualTo(result);
    }*/

}
