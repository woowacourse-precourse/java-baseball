package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {
    @Test
    @DisplayName("컴퓨터가 랜덤으로 선택한 숫자 3개 테스트")
    public void pickRandomNumber() {
        Computer computer = new Computer();
        Map<Integer, Integer> randomNumbers = computer.pickNumbers();
        assertThat(3).isEqualTo(randomNumbers.size());
    }
}
