package baseball;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;

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

        assertThat(turn.getPlayerInput()).isEqualTo(testInput);
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

}
