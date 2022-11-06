package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ComputerTest {
    Computer computer;
    List<Integer> computerNumbers;

    @BeforeEach
    void setUp() {
        computer = new Computer();
        computer.setNumbers();
        computerNumbers = computer.getNumbers();
    }

    @Test
    void 자리_수_테스트() {
        assertEquals(computerNumbers.size(), Config.DIGIT_SIZE);
    }

    @Test
    void 범위_테스트() {
        for (int computerNumber : computerNumbers) {
            assertThat(computerNumber).isBetween(Config.DIGIT_MIN, Config.DIGIT_MAX);
        }
    }

    @Test
    void 중복_테스트() {
        Set<Integer> deduplicationNumbers = new HashSet<>(computerNumbers);

        assertEquals(computerNumbers.size(), deduplicationNumbers.size());
    }
}