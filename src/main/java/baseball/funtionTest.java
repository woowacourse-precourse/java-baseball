package baseball;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static baseball.Application.*;
import static org.junit.jupiter.api.Assertions.*;

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
    @Test
    void 볼_스트라이크_출력_테스트(){
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        assertEquals("1볼 2스트라이크",calculate_Result(list));
        list.set(0,0);
        list.set(1,3);
        assertEquals("3스트라이크",calculate_Result(list));
        list.set(0,2);
        list.set(1,0);
        assertEquals("2볼",calculate_Result(list));
    }
    @Test
    void 사용자_입력에따른_예외처리(){
        String tmp = "1";
        String tmp2 ="112";
        String tmp3 ="123";
        assertThrows(IllegalArgumentException.class,() -> {
            input_number_exception_test(tmp);
        });

        assertThrows(IllegalArgumentException.class,() -> {
            input_number_exception_test(tmp2);
        });

        /*
        assertThrows(IllegalArgumentException.class,() -> {
            input_num_exception_test(tmp3);
        });
        */
    }
    @Test
    void 두개의_문자에서_스트라이크와_볼을_찾아내는지(){
        List<Integer> tmp = new LinkedList<>();
        tmp.add(0);
        tmp.add(3);
        assertSame(tmp, compare_two_case("123","123"));
    }

}
