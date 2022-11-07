package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static baseball.Computer.COMPUTER_INPUT_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {
    private Computer computer;

    @BeforeEach
    void setUp() {
        List<Integer> list = new ArrayList<>();
        computer = new Computer(list);
    }

    @Test
    void 세개의_랜덤수_생성에_성공하는지_테스트() {
        computer.generateRandomNumbers();
        assertThat(computer.getNumbers().size()).isEqualTo(COMPUTER_INPUT_COUNT);
    }
}