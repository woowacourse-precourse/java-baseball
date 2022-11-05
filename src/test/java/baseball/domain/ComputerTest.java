package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @Test
    void createRandomNumbers_해당_게임에_컴퓨터의_랜덤숫자_생성() {
        //given
        Computer computer = new Computer();

        //when
        List<Integer> randomNumbers = computer.createRandomNumbers();

        //then
        List<Integer> distinctNumbers = randomNumbers.stream().distinct().collect(Collectors.toList());
        assertThat(randomNumbers).isEqualTo(distinctNumbers);
    }
}