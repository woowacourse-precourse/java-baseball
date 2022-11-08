package baseball;

import org.junit.jupiter.api.Test;
import java.util.*;
import static baseball.Computer.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
    Computer computer = new Computer();
    List<Integer> list = List.of(2,5,3);
    @Test
    void makeAnswer_컴퓨터_정답_만들기(){
        List<Integer> answer = makeAnswer();
        int result = answer.size();
        assertThat(result).isEqualTo(3);
    }

    @Test
    void resetHintMap_힌트리스트_초기화() {;
        computer.resetHintMap();
        assertThat(HintMap.get("스트라이크")).isEqualTo(0);
        assertThat(HintMap.get("볼")).isEqualTo(0);
    }

    @Test
    void isStrikeOrBall_스트라이크인지_볼인지_판별(){
        computer.resetHintMap();
        computer.Answer = List.of(1,2,3);
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
        computer.Answer = List.of(1,2,3);
        computer.resetHintMap();
        for (int i =0; i<list.size(); i++){
            computer.checkPlayerAnswer(Answer.get(i), list.get(i));
        }
        assertThat(HintMap.get("스트라이크")).isEqualTo(1);
        assertThat(HintMap.get("볼")).isEqualTo(1);
    }

    @Test
    void makeHintMap_플레이어의_답안에_맞춘_HintList_갱신(){
        computer.Answer = List.of(1,2,3);
        computer.resetHintMap();
        computer.makeHintMap(list);
        assertThat(HintMap.get("스트라이크")).isEqualTo(1);
        assertThat(HintMap.get("볼")).isEqualTo(1);
    }

    @Test
    void giveResult_플레이어에게_힌트_출력(){
        computer.Answer = List.of(1,2,3);
        computer.resetHintMap();
        computer.makeHintMap(list);
        computer.giveHint();
        assertThat(computer.result).isEqualTo("1볼 1스트라이크");
    }

    @Test
    void is3Strike_스트라이크가_3개_인지_판별(){
        computer.Answer = List.of(1,2,3);
        computer.resetHintMap();
        List<Integer> list1 = List.of(1,2,3);
        computer.makeHintMap(list1);
        boolean result = computer.is3Strike();
        assertThat(result).isEqualTo(true);
    }
}
