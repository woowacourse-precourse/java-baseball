package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @Test
    void 컴퓨터_숫자_크기_테스트(){
        Computer computer = new Computer();
        computer.reComputerNumber();
        Assertions.assertThat(computer.integerList.size()).isEqualTo(3);
    }
    @Test
    void 컴퓨터_숫자_다른숫자_테스트(){
        Computer computer = new Computer();
        computer.reComputerNumber();
        assertFalse(computer.integerList.get(0).equals(computer.integerList.get(1)));
        assertFalse(computer.integerList.get(0).equals(computer.integerList.get(2)));
    }
}