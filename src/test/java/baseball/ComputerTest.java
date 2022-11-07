package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @Test
    @DisplayName("1~9까지 서로 다른 임의의 수 3개를 선택한다.")
    void selectRandomNumbers() {
        Computer computer = new Computer();
        List<Integer> selectRandomNumbers = computer.selectRandomNumbers();
        List<Integer> compare = new ArrayList<>();
        for (Integer randomNumber : selectRandomNumbers) {
            if (!compare.contains(randomNumber)) {
                compare.add(randomNumber);
            }
        }
        assertThat(selectRandomNumbers.size()).isEqualTo(3);
        assertThat(selectRandomNumbers.size()).isEqualTo(compare.size());
    }

    @Test
    @DisplayName("스트라이크의 숫자를 세는 기능")
    void countStrike() {
        Computer computer = new Computer();
        List<Integer> numbers = computer.selectRandomNumbers();
        Integer compare = 0;
        for (Integer number : numbers) {
            compare = 10 * compare + number;
        }
        assertThat(computer.countStrike(compare)).isEqualTo(3);
        assertThat(computer.countStrike(compare-1)).isEqualTo(2);
        assertThat(computer.countStrike(compare-11)).isEqualTo(1);
    }

    @Test
    @DisplayName("볼의 숫자를 세는 기능")
    void countBall() {
        Computer computer = new Computer();
        List<Integer> numbers = computer.selectRandomNumbers();
        List<Integer> compare = new ArrayList<>();
        for (int i = 1; i < numbers.size(); i++) {
            compare.add(numbers.get(i));
        }
        compare.add(numbers.get(0));
        Integer compareNumber = 0;
        for (Integer number : compare) {
            compareNumber = 10 * compareNumber + number;
        }
        assertThat(computer.countBall(compareNumber)).isEqualTo(3);
    }

    @Test
    @DisplayName("정답 숫자를 입력받는 기능")
    void compare() {
        Computer computer = new Computer();
        List<Integer> numbers = computer.selectRandomNumbers();
        Integer answer = 0;
        for (Integer number : numbers) {
            answer = 10 * answer + number;
        }
        assertThat(computer.compare(answer)).isEqualTo(List.of(3, 0));
    }

    @Test
    @DisplayName("입력받은 숫자에 대한 결과를 출력하는 기능")
    void printResult() {
        Computer computer = new Computer();
        assertThat(computer.printResult(3, 0)).isEqualTo("3스트라이크");
        assertThat(computer.printResult(1, 1)).isEqualTo("1볼 1스트라이크");
        assertThat(computer.printResult(0, 1)).isEqualTo("1볼");
        assertThat(computer.printResult(0, 0)).isEqualTo("낫싱");
    }
}