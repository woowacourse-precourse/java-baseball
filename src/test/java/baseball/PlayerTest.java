package baseball;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static baseball.Player.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {
    @Test
    void splitAnswer_메소드로_입력값_String_to_List(){
        String number = "123";
        List<Integer> list = splitAnswer(number);
        List<Integer> result = List.of(1,2,3);
        assertThat(list).isEqualTo(result);
    }

    @Test
    void getAnswer_메소드로_Player_숫자_입력값_List_저장(){
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<Integer> list = getAnswer();
        List<Integer> result = List.of(1,2,3);

        assertThat(list).isEqualTo(result);
    }

    @Test
    void getAnswer_메소드로_Player_숫자_입력값_validation_length(){
        String input = "12";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        boolean exceptionCatched = false;
        try {
            getAnswer();
        } catch (IllegalArgumentException e) {
            exceptionCatched = true;
        }
        assertTrue(exceptionCatched);
    }
}
