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
        boolean result = computer.isNothing(0);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void isStrikeOrBall_스트라이크인지_볼인지_판별(){
        Computer computer = new Computer();
        List<Integer> list = List.of(0, 0, 0);
        HashMap<String, Integer> result = computer.isStrikeOrBall(list);
        assertThat(result.get("볼")).isEqualTo(3);
    }
}
