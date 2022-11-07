package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @Test
    void 컴퓨터의_숫자_길이_테스트(){
        Computer computer=new Computer();
        assertThat(computer.getComputerNumber().size()).isEqualTo(3);
    }
}