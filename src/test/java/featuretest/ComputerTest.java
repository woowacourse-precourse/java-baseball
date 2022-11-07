package featuretest;

import baseball.Computer;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ComputerTest {

    public Computer computer;

    @BeforeEach
    public void 멤버_초기화(){
        computer = new Computer();
        computer.clearNumberCount();
    }

    @Test
    void 정답번호_생성검증(){
        computer.makeAnswerNumber();
        assertThat(computer.getAnswerNumber().size()).isEqualTo(3);
    }

    @Test
    void 스트라이크_볼_체크(){
        List<Integer> testAnswerNumber = List.of(1, 4, 5);
        List<Integer> testUserNumber = List.of(4, 1, 5);
        computer.setAnswerNumber(testAnswerNumber);
        computer.checkNumberCount(testUserNumber);
        assertThat(computer.getBall()).isEqualTo(2);
        assertThat(computer.getStrike()).isEqualTo(1);
    }
}
