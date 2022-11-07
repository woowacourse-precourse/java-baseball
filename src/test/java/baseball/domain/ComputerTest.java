package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    @DisplayName("init() 메서드 호출시 randomNumbers 1~9 사이의 숫자 서로 다른 숫자가 생성")
    void init() {
        Computer computer = Computer.of();

        // when
        computer.init();
        List<Integer> randomNumbers = computer.getRandomNumbers();

        // then
        assertRandomNumbers(randomNumbers);
    }

    public static void assertRandomNumbers(List<Integer> randomNumbers) {
        assertThat(randomNumbers.size()).isEqualTo(3);

        for (Integer randomNumber : randomNumbers) {
            assertThat(randomNumber >= 1 && randomNumber <= 9).isTrue();
        }

        for (int i = 0; i < randomNumbers.size(); i++) {
            assertThat(randomNumbers.get(i) >= 1 && randomNumbers.get(i) <= 9).isTrue();

            assertThat(!Objects.equals(
                    randomNumbers.get(i % 3),
                    randomNumbers.get((i + 1) % 3))
            ).isTrue();
        }
    }
}
