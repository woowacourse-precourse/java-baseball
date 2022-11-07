package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
    private static Computer computer;

    @BeforeEach
    private void createComputer() {
        computer = new Computer();
    }

    @Test
    void 정답_숫자_유효성_검사() {
        computer.generateNewRandomAnswer();
        List<Integer> numbers = computer.getAnswerNumber();
        assertThat(computer.isValidNumber(numbers)).isTrue();
    }
}
