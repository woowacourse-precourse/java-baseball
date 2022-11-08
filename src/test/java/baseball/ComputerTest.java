package baseball;

import baseball.constant.Config;
import baseball.model.Computer;
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
    void 생성한_수의_자리_수가_올바르다() {
        assertEquals(computerNumbers.size(), Config.DIGIT_SIZE);
    }

    @Test
    void 생성한_수의_범위가_올바르다() {
        for (int computerNumber : computerNumbers) {
            assertThat(computerNumber).isBetween(Config.DIGIT_MIN, Config.DIGIT_MAX);
        }
    }

    @Test
    void 생성한_수에_중복이_없다() {
        Set<Integer> deduplicationNumbers = new HashSet<>(computerNumbers);

        assertEquals(computerNumbers.size(), deduplicationNumbers.size());
    }
}