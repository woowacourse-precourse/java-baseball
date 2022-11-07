package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    @DisplayName("컴퓨터가 게임이 시작되면 실행되는 메서드 - generateRandomNumber를 호출")
    void init() {
        Computer computer = Computer.of();

        // when
        computer.init();
        List<Integer> randomNumbers = computer.getRandomNumbers();

        // then
        assertThat(randomNumbers.size()).isEqualTo(3);
        assertThat(!Objects.equals(randomNumbers.get(0), randomNumbers.get(1))).isTrue();
        assertThat(!Objects.equals(randomNumbers.get(1), randomNumbers.get(2))).isTrue();
        assertThat(!Objects.equals(randomNumbers.get(2), randomNumbers.get(0))).isTrue();
    }
}
