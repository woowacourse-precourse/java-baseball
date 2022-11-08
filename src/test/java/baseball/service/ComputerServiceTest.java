package baseball.service;

import baseball.domain.Computer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class ComputerServiceTest {
    Computer computer;
    ComputerService computerService = new ComputerService();

    @BeforeEach
    void initComputer() {
        computerService.initComputer();
        computer = computerService.getComputer();
    }

    @Test
    @DisplayName("리스트의 사이즈는 3")
    void case1() {
        List<Integer> numbers = computer.getNumbers();
        Assertions.assertThat(numbers).hasSize(3);
    }

    @Test
    @DisplayName("컴퓨터의 숫자는 1부터 9사이")
    void case2() {
        List<Integer> numbers = computer.getNumbers();
        for (Integer number : numbers) {
            Assertions.assertThat(number).isPositive().isLessThan(10);
        }
    }
}
