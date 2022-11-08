package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.Computer;
import java.util.List;
import org.junit.jupiter.api.Test;

class ComputerTest {
    @Test
    void 컴퓨터_수는_3자리_이다() {
        Computer computer = new Computer();
        List<Integer> computerNumbers = computer.createComputerNumbers();

        assertThat(computerNumbers).hasSize(3);
    }
}