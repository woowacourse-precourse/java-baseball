package baseball.players;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @Test
    void 컴퓨터의_숫자_생성을_확인하는_기능() {
        Computer computer = new Computer();
        List<Integer> computerNumbers = computer.getComputerNumbers();
        assertThat(computerNumbers.size()).isEqualTo(3);
    }

    @Test
    void 컴퓨터의_중복된_숫자_생성하는지_확인하는_기능() {
        Computer computer = new Computer();
        List<Integer> computerNumbers = computer.getComputerNumbers();

        Map<Integer, Integer> dupCheck = new HashMap<>();

        for (int numbers : computerNumbers)
            dupCheck.put(numbers, 0);

        assertThat(dupCheck.size()).isEqualTo(3);
    }
}