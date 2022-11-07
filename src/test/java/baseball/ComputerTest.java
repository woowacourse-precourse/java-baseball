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
    void isNothing_낫싱인지_판별(){
        Computer computer = new Computer();
        List<Integer> list_1 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> list_2 = List.of(0, 0, 0);
        boolean result_1 = computer.isNothing(list_1);
        boolean result_2 = computer.isNothing(list_2);
        assertThat(result_1).isEqualTo(false);
        assertThat(result_2).isEqualTo(true);
    }

    @Test
    void isStrikeOrBall_스트라이크인지_볼인지_판별(){
        Computer computer = new Computer();
        List<Integer> list = List.of(0, 0, 0);
        HashMap<String, Integer> result = computer.isStrikeOrBall(list);
        assertThat(result.get("볼")).isEqualTo(3);
    }
}
