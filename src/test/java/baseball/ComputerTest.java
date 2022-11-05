package baseball;

import baseball.participant.Computer;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @Test
    void selectRandomNumber() {
        // given
        Computer computer = new Computer();

        // when
        String randomNumber = computer.selectRandomNumber();
        Set<String> set = Arrays.stream(randomNumber.split("")).collect(Collectors.toSet());

        // then
        assertThat(set.size()).isEqualTo(3);
        assertThat(randomNumber.matches("[1-9]+")).isTrue();
    }
}