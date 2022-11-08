package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static baseball.domain.Player.*;
import static baseball.SystemMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {

    @Test
    void splitAnswer_메소드로_입력값_String_to_List() {
        String number = "123";
        List<Integer> list = splitAnswer(number);
        List<Integer> result = List.of(1, 2, 3);
        assertThat(list).isEqualTo(result);
    }

    @Test
    void getAnswer_메소드로_Player_숫자_입력값_List_저장() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<Integer> list = getAnswer();
        List<Integer> result = List.of(1, 2, 3);

        assertThat(list).isEqualTo(result);
    }

    @Test
    void getAnswer_메소드로_Player_숫자_입력값_validation_length() {
        String input = "12";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String valid_message = "";
        try {
            getAnswer();
        } catch (IllegalArgumentException e) {
            valid_message = e.getMessage();
        }
        assertThat(valid_message).isEqualTo(INVALID_LENGTH);
    }

    @Test
    void getAnswer_메소드로_Player_숫자_입력값_validation_number() {
        String input = "019";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String valid_message = "";
        try {
            getAnswer();
        } catch (IllegalArgumentException e) {
            valid_message = e.getMessage();
        }
        assertThat(valid_message).isEqualTo(INVALID_NUMBER);
    }

    @Test
    void getAnswer_메소드로_Player_숫자_입력값_validation_duplicate() {
        String input = "112";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String valid_message = "";
        try {
            getAnswer();
        } catch (IllegalArgumentException e) {
            valid_message = e.getMessage();
        }
        assertThat(valid_message).isEqualTo(DUPLICATE_NUMBER);
    }
}
