package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    Computer computer = new Computer();

    @Test
    void initRandomNumbers() {
        computer.initRandomNumbers();

        List<Integer> randomNumbers = computer.getBallCounts();
        Set<Integer> deduplicatedNumbers = new HashSet<>(randomNumbers);

        assertEquals(randomNumbers.size(), 3);
        assertEquals(randomNumbers.size(), deduplicatedNumbers.size());
    }

    @Test
    void clearRandomNumbers() {
        computer.clearRandomNumbers();
        assertEquals(computer.getBallCounts().size(), 0);
    }
}