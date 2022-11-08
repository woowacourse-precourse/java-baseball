package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @Test
    void computerSelectNumbers() {
        Computer computer = new Computer();
        List<Integer> selectNumbersList = computer.computerSelectNumbers();
        assertThat(selectNumbersList.size()).isEqualTo(3);

        Set<Integer> selectNumbersHash = new HashSet<>(selectNumbersList);
        assertThat(selectNumbersHash.size()).isEqualTo(3);
    }
}