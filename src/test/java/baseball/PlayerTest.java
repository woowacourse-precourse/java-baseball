package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.Player.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @Test
    void splitAnswer_메소드로_입력값_String_to_List(){
        String number = "123";
        List<Integer> list = splitAnswer(number);
        List<Integer> result = List.of(1,2,3);
        assertThat(list).isEqualTo(result);
    }
}
