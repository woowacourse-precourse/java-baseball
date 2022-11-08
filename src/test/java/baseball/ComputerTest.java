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
    void reset_스트라이크인지_볼인지_판별() {
        Computer computer = new Computer();
        computer.resetHintMap();
        HashMap<String, Integer> result = HintMap;
        assertThat(HintMap.get("스트라이크")).isEqualTo(0);
        assertThat(HintMap.get("볼")).isEqualTo(0);
        assertThat(HintMap.get("낫싱")).isEqualTo(0);
    }
    @Test
    void isNothing_낫싱인지_판별(){
        Computer computer = new Computer();
        computer.resetHintMap();
        List<Integer> list = List.of(0, 0, 0);
        for (int i =0; i<list.size(); i++){
            computer.isNothing(list.get(i));
        }
        int result = HintMap.get("낫싱");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void isStrikeOrBall_스트라이크인지_볼인지_판별(){
        Computer computer = new Computer();
        computer.resetHintMap();
        List<Integer> list = List.of(0, 0, 0);
        for (int i =0; i<list.size(); i++){
            computer.isStrikeOrBall(Answer.get(i), list.get(i));
        }
        int result = HintMap.get("볼");
        assertThat(result).isEqualTo(3);
    }
}
