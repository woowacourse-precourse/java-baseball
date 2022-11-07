package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.regex.Pattern;


public class ComputerTest {

    private Computer computer;

    @BeforeEach
    void before() {
        computer = new Computer();
    }

    @DisplayName("컴퓨터의 난수 유효성 테스트")
    @Test
    public void computer_number_count_check() {
        List<Integer> computerNumber = computer.getComputerNumber();

        Assertions.assertThat(computerNumber.size()).isEqualTo(3);
    }

    @DisplayName("컴퓨터의 3자리 난수 범위 [1, 9] 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    public void computer_number_range_check(int i) {
        List<Integer> computerNumber = computer.getComputerNumber();

        String result = String.valueOf(computerNumber.get(i));
        Assertions.assertThat(Pattern.matches("^[1-9]*$", result)).isTrue();
    }

}
