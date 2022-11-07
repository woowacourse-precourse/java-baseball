package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @Test
    void 서로_다른_3개_수_뽑기() {
        Computer computer = new Computer();
        computer.pickRandomNumber();
        List<Integer> pickedNumbers = computer.getTargetRandomNumber();
        assertThat(pickedNumbers.get(0)).isNotEqualTo(pickedNumbers.get(1))
                .isNotEqualTo(pickedNumbers.get(2));
    }
}