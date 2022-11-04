package baseball;

import org.junit.jupiter.api.Test;

import static baseball.Application.is_Strike_or_Ball;
import static baseball.Application.select_Random_Number;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class funtionTest {
    @Test
    void 볼_스트라이크를_잘_찾아내는지() {
        String com = "123";
        String num = "2";
        int index = 1;
        assertEquals(1,is_Strike_or_Ball(com,num,index));
        com = "123";
        num = "1";
        index = 1;
        assertEquals(0,is_Strike_or_Ball(com,num,index));
    }
}
