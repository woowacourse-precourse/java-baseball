package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @Test
    void random3NumberOutput() {
        
        Computer computer = new Computer(new ArrayList<>());
        computer.random3NumberOutput();
        HashSet<Integer> set = new HashSet<>(computer.computerNumber);
        org.assertj.core.api.Assertions.assertThat(set.size()).isEqualTo(computer.computerNumber.size());

    }
}