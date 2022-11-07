package study;

import baseball.logic.Randomnumber;
import org.junit.jupiter.api.Test;

import java.util.List;

public class generateNumTest {
    @Test
    void randomnum() {
        Randomnumber generate = new Randomnumber();
        List<Integer> list = generate.getNum();
        System.out.println(list);
    }
}
