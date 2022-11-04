package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
    Computer computer;
    @BeforeEach
    void beforeEach() {
        computer = new Computer();
    }
    @Test
    void create_computer_number() {
        List<Integer> targetNumber = computer.pickTargetNumber();
        Set<Integer> numberSet = new HashSet<>(targetNumber);
        assertThat(targetNumber.size()).isEqualTo(numberSet.size());
    }
    @Test
    void compare_test() {
        computer.targetNumber = List.of(1,2,3);
        assertThat(computer.compare(List.of(1, 2, 3)).strike == 3);
        assertThat(computer.compare(List.of(1, 2, 3)).ball == 0);
        assertThat(computer.compare(List.of(2, 1, 3)).strike == 1);
        assertThat(computer.compare(List.of(2, 1, 3)).ball == 2);
        assertThat(computer.compare(List.of(4, 5, 6)).strike == 0);
        assertThat(computer.compare(List.of(4, 5, 6)).ball == 0);
    }
}
