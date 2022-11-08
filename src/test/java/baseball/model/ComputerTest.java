package baseball.model;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    @DisplayName("3자리 숫자를 생성할 수 있다.")
    void generateNumbers_Success() {
        Computer computer = new Computer();
        List<Integer> numbers = computer.getNumbers();

        assertThat(numbers.size()).isEqualTo(3);
    }
}