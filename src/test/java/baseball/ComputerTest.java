package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
    private static Computer computer;

    @Test
    void 숫자_유효성_검사_함수_검사() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        assertThat(computer.isValidNumber(numbers)).isTrue();
    }

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

    @Test
    void 정답_숫자와_비교_결과_검사() {
        computer.generateNewRandomAnswer();
        List<Integer> numbers = computer.getAnswerNumber();
        assertThat(computer.compareWithAnswer(numbers)).isEqualTo(Arrays.asList(3, 0));
    }

}
