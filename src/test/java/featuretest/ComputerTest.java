package featuretest;

import baseball.Computer;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComputerTest {

    public Computer computer;

    @BeforeEach
    public void 멤버_초기화(){
        computer = new Computer();
    }

    @Test
    void 정답번호_생성검증(){
        computer.makeAnswerNumber();
        assertThat(computer.getAnswerNumber().size()).isEqualTo(3);
    }
}
