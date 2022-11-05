package study;

import baseball.model.ComputerRandomNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BaseballTest {
    @Test
    void RandomNumberTest() {
        int len = 3;
        ComputerRandomNumber computerRandomNumber = new ComputerRandomNumber();
        List<Integer> result = computerRandomNumber.getComputerNumber();
        assertThat(result.size()).isEqualTo(len);
        System.out.println(result);
    }
}
