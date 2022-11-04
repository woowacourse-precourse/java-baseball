package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @Test
    public void 길이3_만큼의_랜덤숫자가_생성되는지_확인() {
        Computer computer = new Computer();
        List<Integer> randomNumbers = computer.getRandomNumbers();

        assertThat(randomNumbers.size()).isEqualTo(3);
    }

    @Test
    public void 모든_숫자가_서로_다른_숫자인지_확인() {
        Computer computer = new Computer();
        List<Integer> randomNumbers = computer.getRandomNumbers();

        assertThat(randomNumbers.get(0)).isNotEqualTo(randomNumbers.get(1));
        assertThat(randomNumbers.get(0)).isNotEqualTo(randomNumbers.get(2));
        assertThat(randomNumbers.get(1)).isNotEqualTo(randomNumbers.get(2));
    }
}