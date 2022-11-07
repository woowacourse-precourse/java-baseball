package baseball;

import org.junit.jupiter.api.Test;
import java.util.*;
import static baseball.Computer.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {

    @Test
    void makeAnswer_컴퓨터_정답_만들기(){
        List<Integer> answer = makeAnswer();
        int result = answer.size();
        assertThat(result).isEqualTo(3);
    }

    @Test
    void hasSameNumber_같은_숫자가_있는가_판별(){
        Computer computer = new Computer();
        List<Integer> case_1 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> case_2 = List.of(0, 0, 0);
        boolean result_1 = computer.hasSameNumber(case_1);
        boolean result_2 = computer.hasSameNumber(case_2);
        assertThat(result_1).isEqualTo(true);
        assertThat(result_2).isEqualTo(false);
    }
}
