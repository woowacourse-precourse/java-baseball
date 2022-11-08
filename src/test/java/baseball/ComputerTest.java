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
    void resetHintMap_힌트리스트_초기화() {
        Computer computer = new Computer();
        computer.resetHintMap();
        assertThat(HintMap.get("스트라이크")).isEqualTo(0);
        assertThat(HintMap.get("볼")).isEqualTo(0);
    }

    @Test
    void isStrikeOrBall_스트라이크인지_볼인지_판별(){
        Computer computer = new Computer();
        computer.resetHintMap();
        computer.Answer = List.of(1,2,3);
        List<Integer> list = List.of(2,1,3);
        for (int i =0; i<list.size(); i++){
            computer.isStrikeOrBall(Answer.get(i), list.get(i));
        }
        int strike = HintMap.get("스트라이크");
        int ball = HintMap.get("볼");
        assertThat(strike).isEqualTo(1);
        assertThat(ball).isEqualTo(2);
    }

    @Test
    void checkPlayerAnswer_플레이어의_정답을_비교(){
        Computer computer = new Computer();
        computer.Answer = List.of(1,2,3);
        computer.resetHintMap();
        List<Integer> list = List.of(2,5,3);
        for (int i =0; i<list.size(); i++){
            computer.checkPlayerAnswer(Answer.get(i), list.get(i));
        }
        assertThat(HintMap.get("스트라이크")).isEqualTo(1);
        assertThat(HintMap.get("볼")).isEqualTo(1);
    }

    @Test
    void makeHintMap_플레이어의_답안에_맞춘_HintList_갱신(){
        Computer computer = new Computer();
        computer.Answer = List.of(1,2,3);
        computer.resetHintMap();
        List<Integer> list = List.of(2,5,3);        computer.makeHintMap(list);
        assertThat(HintMap.get("스트라이크")).isEqualTo(1);
        assertThat(HintMap.get("볼")).isEqualTo(1);
    }

}
