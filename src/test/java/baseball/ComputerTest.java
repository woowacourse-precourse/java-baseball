package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
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
    @Test
    void 스트라이크3_테스트() {
        Computer computer = new Computer();
        computer.setTargetRandomNumber(Arrays.asList(1,2,3));

        computer.calculateStrikeBall(Arrays.asList(1,2,3));
        assertThat(computer.getStrike()).isEqualTo(3);
        assertThat(computer.getBall()).isEqualTo(0);

        assertThat(computer.isThreeStrike()).isTrue();
    }
    @Test
    void 볼3_테스트() {
        Computer computer = new Computer();
        computer.setTargetRandomNumber(Arrays.asList(1,2,3));
        computer.calculateStrikeBall(Arrays.asList(2,3,1));
        assertThat(computer.getStrike()).isEqualTo(0);
        assertThat(computer.getBall()).isEqualTo(3);
    }

    @Test
    void 스트라이크_볼_테스트() {
        Computer computer = new Computer();
        computer.setTargetRandomNumber(Arrays.asList(1,2,3));

        computer.calculateStrikeBall(Arrays.asList(3,2,1));
        assertThat(computer.getStrike()).isEqualTo(1);
        assertThat(computer.getBall()).isEqualTo(2);

        computer.calculateStrikeBall(Arrays.asList(4,5,6));
        assertThat(computer.getStrike()).isEqualTo(0);
        assertThat(computer.getBall()).isEqualTo(0);
    }

}