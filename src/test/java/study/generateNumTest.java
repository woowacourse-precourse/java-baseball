package study;

import baseball.logic.Generatenumber;
import org.junit.jupiter.api.Test;

import java.util.List;

public class generateNumTest {
    @Test
    void randomnum() {
        Generatenumber generate = new Generatenumber();
        List<Integer> list = generate.getNum();
        System.out.println(list);
    }
}
