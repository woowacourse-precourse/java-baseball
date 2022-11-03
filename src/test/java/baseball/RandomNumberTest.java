package baseball;

import baseball.model.Computer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomNumberTest {

    @Test
    void 랜덤숫자_3개_생성() {
        Computer computer = new Computer();
        computer.setRandomNumbers();
        assertThat(computer.getComputerNumbers().size()).isEqualTo(3);
    }

    @Test
    void 랜덤숫자가_겹치는지_확인() {
        Computer computer = new Computer();
        List<Integer> numbers = Arrays.asList(1, 1, 2);
        assertThat(computer.isRandomNumbersUnique(numbers)).isEqualTo(false);
    }
}
