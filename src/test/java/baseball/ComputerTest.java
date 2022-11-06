package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ComputerTest {
    private static Computer computer;

    @Test
    @BeforeAll
    static void 객체_생성_테스트() {
        computer = new Computer();
        assertThat(computer).isNotNull();
    }

    @Test
    void 숫자_생성_테스트() {
        computer.generateUniqueRandomNumbers();
        assertThat(computer.getRandomNumbers())
                .isNotNull();
    }

    @Test
    void 숫자_길이_테스트() {
        computer.generateUniqueRandomNumbers();
        assertThat(computer.getRandomNumbers())
                .isNotEmpty()
                .size()
                .isEqualTo(Computer.RANDOM_NUMBERS_SIZE);
    }

    @Test
    void 숫자_중복_확인_테스트() {
        computer.generateUniqueRandomNumbers();
        assertThat(computer.getRandomNumbers())
                .doesNotHaveDuplicates();
    }

    @Test
    void 숫자_범위_테스트() {
        computer.generateUniqueRandomNumbers();
        List<Integer> randomNumbers = computer.getRandomNumbers();
        for (Integer randomNumber : randomNumbers) {
            assertThat(randomNumber)
                    .isGreaterThanOrEqualTo(Computer.START_NUMBER)
                    .isLessThanOrEqualTo(Computer.END_NUMBER);
        }
    }
}
