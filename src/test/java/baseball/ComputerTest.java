package baseball;

import baseball.domain.Computer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ComputerTest {

    public ComputerTest() {
        컴퓨터의_랜덤숫자_리스트의_크기는_3();
        컴퓨터의_랜덤숫자_범위는_1부터9();
    }

    @Test
    void 컴퓨터의_랜덤숫자_리스트의_크기는_3() {
        Computer computer = new Computer();
        List<Integer> randomNumbers = computer.getRandomNumbers();
        Assertions.assertThat(randomNumbers).hasSize(3);
    }

    @Test
    void 컴퓨터의_랜덤숫자_범위는_1부터9() {
        Set<Integer> range = new HashSet<>();
        for (int count = 1; count <= 10000; count++) {
            Computer computer = new Computer();
            List<Integer> randomNumbers = computer.getRandomNumbers();
            range.addAll(randomNumbers);
        }
        Assertions.assertThat(range).containsOnly(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }
}
