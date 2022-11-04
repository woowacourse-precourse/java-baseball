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
}
