package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
    @Test
    void constructorTest() {
        Computer computer = new Computer();
        List<Integer> answer = computer.getAnswer();
        int result = 3;
        assertThat(answer.size()).isEqualTo(result);
        int number1 = answer.get(0);
        int number2 = answer.get(1);
        int number3 = answer.get(2);
        assertThat(number1).isNotEqualTo(number2);
        assertThat(number2).isNotEqualTo(number3);
        assertThat(number3).isNotEqualTo(number1);
    }
}
