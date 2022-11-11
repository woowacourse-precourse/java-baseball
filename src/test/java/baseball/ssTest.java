package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ssTest {

    @Test
    void 비교기_테스트(){

        ss compare = new ss();

        List<Integer> computer = new ArrayList<>(); // 3,1,2
        computer.add(3);
        computer.add(1);
        computer.add(2);

        List<Integer> user = new ArrayList<>(); // 3,2,1
        user.add(3);
        user.add(2);
        user.add(1);


        List<Integer> SBLIST = compare.countTest(computer,user);

        List<Integer> SBEXPECT = new ArrayList<>(); // strike 1, ball 2
        SBEXPECT.add(1);
        SBEXPECT.add(2);


        assertEquals(SBLIST, SBEXPECT);


    }

}