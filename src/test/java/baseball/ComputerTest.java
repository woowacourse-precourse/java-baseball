package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ComputerTest {
    @Test
    void 컴퓨터의_랜덤숫자_리스트의_크기는_3() {
        Computer computer = new Computer();
        computer.inputRandomNumbers();
        List<Integer> randomNumbers = computer.getRandomNumbers();
        Assertions.assertThat(3).isEqualTo(randomNumbers.size());
    }
}
