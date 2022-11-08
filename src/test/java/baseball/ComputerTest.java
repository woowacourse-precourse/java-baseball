package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {
    Computer computer = new Computer();

    @Test
    void 랜덤_수_리스트를_호출한다() {
        List<Integer> list = computer.getRandomNumbers();

        int one = list.get(0);
        int two = list.get(1);
        int three = list.get(2);

        assertThat(one).isNotEqualTo(two);
        assertThat(two).isNotEqualTo(three);
        assertThat(three).isNotEqualTo(one);
    }
}