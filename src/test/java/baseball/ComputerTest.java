package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.logging.Logger;

class ComputerTest {
    @Test
    void 컴퓨터의_랜덤숫자_리스트의_크기는_3() {
        Computer computer = new Computer();
        List<Integer> randomNumbers = computer.getRandomNumbers();
        System.out.println(randomNumbers.toString());
        Assertions.assertThat(randomNumbers).hasSize(3);
    }
}
