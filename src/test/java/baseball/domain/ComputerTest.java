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

    @Test
    @DisplayName("주어진 값에 따른 볼 Count 메소드")
    void getBallCountByRandomNumbersTest() {
        // given
        // testNumbers = [1, 2, 3]
        Computer computer = Computer.of();
        computer.generateTestNumbers();
        List<Integer> testNumbers = computer.getRandomNumbers();

        // when
        List<Integer> userNumbers = List.of(1, 2, 3);
        List<Integer> userNumbers2 = List.of(2, 3, 1);
        List<Integer> userNumbers3 = List.of(4, 5, 6);
        List<Integer> userNumbers4 = List.of(2, 5, 6);


        // then
        assertThat(computer.getBallCounts(userNumbers)).isEqualTo(0);
        assertThat(computer.getBallCounts(userNumbers2)).isEqualTo(3);
        assertThat(computer.getBallCounts(userNumbers3)).isEqualTo(0);
        assertThat(computer.getBallCounts(userNumbers4)).isEqualTo(1);
    }

    @Test
    @DisplayName("주어진 값에 따른 스트라이크 Count 메소드")
    void getStrikeCountByRandomNumbersTest() {
        // given
        // testNumbers = [1, 2, 3]
        Computer computer = Computer.of();
        computer.generateTestNumbers();
        List<Integer> testNumbers = computer.getRandomNumbers();

        // when
        List<Integer> userNumbers = List.of(1, 2, 3);
        List<Integer> userNumbers2 = List.of(2, 3, 1);
        List<Integer> userNumbers3 = List.of(4, 5, 6);
        List<Integer> userNumbers4 = List.of(2, 5, 6);
        List<Integer> userNumbers5 = List.of(1, 5, 6);

        // then
        assertThat(computer.getStrikeCounts(userNumbers)).isEqualTo(3);
        assertThat(computer.getStrikeCounts(userNumbers2)).isEqualTo(0);
        assertThat(computer.getStrikeCounts(userNumbers3)).isEqualTo(0);
        assertThat(computer.getStrikeCounts(userNumbers4)).isEqualTo(0);
        assertThat(computer.getStrikeCounts(userNumbers5)).isEqualTo(1);
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
