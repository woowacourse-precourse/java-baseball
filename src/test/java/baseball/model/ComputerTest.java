package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {
    @Test
    @DisplayName("컴퓨터가 뽑은 숫자가 중복 여부 판정")
    void computerSelectNumbers() {
        Computer computer = new Computer();
        List<Integer> selectNumbersList = computer.computerSelectNumbers();
        assertThat(selectNumbersList.size()).isEqualTo(3);

        Set<Integer> selectNumbersHash = new HashSet<>(selectNumbersList);
        assertThat(selectNumbersHash.size()).isEqualTo(3);
    }
}