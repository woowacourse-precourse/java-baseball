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
    void transformPlayerInputToList_test_transforming_input_string_to_list() {
        Turn turn = new Turn();
        String testInput = "234";
        final byte[] buf = String.join("\n", testInput).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        turn.transformPlayerInputToList();
        try {
            Field field = turn.getClass().getDeclaredField("playerNumberList");
            field.setAccessible(true);

            List<Integer> list = (List<Integer>) field.get(turn);

            List<Integer> result = List.of(2, 3, 4);

            assertThat(list).isEqualTo(result);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getPlayerInput_test_getting_input() {
        Turn turn = new Turn();
        String testInput = "234";
        final byte[] buf = String.join("\n", testInput).getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThat(turn.getPlayerInput("숫자를 입력해주세요 : ")).isEqualTo(testInput);
    }

    @Test
    void validatePlayerNumberList_test_input_length_larger_than_3(){
        Turn turn = new Turn();
        String testInput = "1234";
        final byte[] buf = String.join("\n", testInput).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        turn.transformPlayerInputToList();
        assertThatThrownBy(() -> turn.validatePlayerNumberList())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3개의 숫자만 입력해주세요.");
    }

    @Test
    void validatePlayerNumberList_test_input_length_smaller_than_3(){
        Turn turn = new Turn();
        String testInput = "12";
        final byte[] buf = String.join("\n", testInput).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        turn.transformPlayerInputToList();
        assertThatThrownBy(() -> turn.validatePlayerNumberList())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3개의 숫자만 입력해주세요.");
    }

    @Test
    void validatePlayerNumberList_test_input_including_non_number_character(){
        Turn turn = new Turn();
        String testInput = "ab-";
        final byte[] buf = String.join("\n", testInput).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        turn.transformPlayerInputToList();
        assertThatThrownBy(() -> turn.validatePlayerNumberList())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력해 주세요.");
    }

    @Test
    void validatePlayerNumberList_test_input_including_redundant_numbers(){
        Turn turn = new Turn();
        String testInput = "112";
        final byte[] buf = String.join("\n", testInput).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        turn.transformPlayerInputToList();
        assertThatThrownBy(() -> turn.validatePlayerNumberList())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("서로 다른 숫자만 입력해주세요.");
    }

    @Test
    void countNumberOfStrikes_test_strike_count() {
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);

        Turn turn = new Turn();

        String testInput = "234";
        final byte[] buf = String.join("\n", testInput).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        turn.transformPlayerInputToList();
        turn.countNumberOfStrikes(testHiddenNumberList);
        try {
            Field turnField = turn.getClass().getDeclaredField("numberOfStrikes");
            turnField.setAccessible(true);

            int numberOfStrikes = (int) turnField.get(turn);

            assertThat(numberOfStrikes).isEqualTo(2);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    void countNumberOfBalls_test_ball_count() {
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);

        Turn turn = new Turn();

        String testInput = "132";
        final byte[] buf = String.join("\n", testInput).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        turn.transformPlayerInputToList();
        turn.countNumberOfBalls(testHiddenNumberList);
        try {
            Field turnField = turn.getClass().getDeclaredField("numberOfBalls");
            turnField.setAccessible(true);

            int numberOfBalls = (int) turnField.get(turn);

            assertThat(numberOfBalls).isEqualTo(1);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    void printResult_test_print_result_1ball_1strike() {

        List<Integer> testHiddenNumberList = List.of(2, 3, 5);

        Turn turn = new Turn();

        String testInput = "251\n";
        final byte[] buf = String.join("\n", testInput).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        turn.transformPlayerInputToList();
        turn.countNumberOfBalls(testHiddenNumberList);
        turn.countNumberOfStrikes(testHiddenNumberList);

        String result = "1볼 1스트라이크\r\n";

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        turn.printResult();

        assertThat(out.toString()).isEqualTo(result);
    }

    @Test
    void printResult_test_print_result_0ball_3strike() {

        List<Integer> testHiddenNumberList = List.of(2, 3, 5);

        Turn turn = new Turn();

        String testInput = "235\n";
        final byte[] buf = String.join("\n", testInput).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        turn.transformPlayerInputToList();
        turn.countNumberOfBalls(testHiddenNumberList);
        turn.countNumberOfStrikes(testHiddenNumberList);

        String result = "3스트라이크\r\n";

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        turn.printResult();

        assertThat(out.toString()).isEqualTo(result);
    }

    @Test
    void printResult_test_print_result_3ball() {

        List<Integer> testHiddenNumberList = List.of(2, 3, 5);

        Turn turn = new Turn();

        String testInput = "352\n";
        final byte[] buf = String.join("\n", testInput).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        turn.transformPlayerInputToList();
        turn.countNumberOfBalls(testHiddenNumberList);
        turn.countNumberOfStrikes(testHiddenNumberList);

        String result = "3볼\r\n";

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        turn.printResult();

        assertThat(out.toString()).isEqualTo(result);
    }

    @Test
    void getStrikeResultString_test_strike_result() {
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);

        Turn turn = new Turn();

        String testInput = "231";
        final byte[] buf = String.join("\n", testInput).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        turn.transformPlayerInputToList();
        turn.countNumberOfStrikes(testHiddenNumberList);

        String result = "2스트라이크";

        assertThat(turn.getStrikeResultString()).isEqualTo(result);
    }

    @Test
    void getBallResultString_test_ball_result() {
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);

        Turn turn = new Turn();

        String testInput = "251";
        final byte[] buf = String.join("\n", testInput).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        turn.transformPlayerInputToList();
        turn.countNumberOfBalls(testHiddenNumberList);

        String result = "1볼";

        assertThat(turn.getBallResultString()).isEqualTo(result);
    }

    @Test
    void isStrikeOut_test_strike_out() {
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);

        Turn turn = new Turn();

        String testInput = "235";
        final byte[] buf = String.join("\n", testInput).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        turn.transformPlayerInputToList();
        turn.countNumberOfStrikes(testHiddenNumberList);

        boolean result = true;

        assertThat(turn.isStrikeOut()).isEqualTo(result);
    }

}
