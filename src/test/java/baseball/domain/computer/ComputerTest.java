package baseball.domain.computer;

import baseball.domain.computer.generator.NumberGenerator;
import baseball.domain.computer.generator.RandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {
    private Computer computer;

    @BeforeEach
    void init() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        computer = new Computer(numberGenerator);
        computer.setRandomNumbers();
    }

    @Test
    @DisplayName("각 수는 중복되지 않는다.")
    void 중복_확인_테스트() {
        List<Integer> randomNums = computer.getRandomNumbers();

        long numCount = randomNums.stream()
                .distinct()
                .count();

        assertThat(numCount).isEqualTo(3);
    }

    @Test
    @DisplayName("각 수는 1 ~ 9 범위를 벗어나지 않는다.")
    void 자리수의_범위_확인_테스트() {
        List<Integer> randomNums = computer.getRandomNumbers();

        long zeroCount = randomNums
                .stream()
                .filter(n -> n == 0)
                .count();

        assertThat(zeroCount).isEqualTo(0);
    }

    @Test
    @DisplayName("생성한 난수의 크기는 3이다.")
    void 난수크기_확인_테스트() {
        List<Integer> randomNums = computer.getRandomNumbers();

        int randomNumLength = randomNums.size();

        assertThat(randomNumLength).isEqualTo(3);
    }
}
