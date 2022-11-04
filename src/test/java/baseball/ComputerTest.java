package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @Test
    void computer_난수값_생성이_제대로_되는지_테스트() {
        // given
        Computer computer = new Computer(new NumberGenerator());

        // when
        computer.generateNumbers();

        // then
        List<Integer> numbers = computer.getNumbers();
        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers.stream().allMatch(number -> number >= 1 && number <= 9)).isTrue();
    }
}