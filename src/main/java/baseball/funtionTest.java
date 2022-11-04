package baseball;

import org.junit.jupiter.api.Test;
import static baseball.Application.select_Random_Number;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class funtionTest {
    @Test
    void 컴퓨터의_입력값() {
        String tmp = select_Random_Number();
        int tmp_len = tmp.length();
        assertEquals(3,tmp_len);
    }
    @Test
    void 사용자의_입력값() {

    }
}
