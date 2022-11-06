package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
    @DisplayName("컴퓨터 랜덤 숫자 사이즈 테스트")
    @Test
    void computersNumberSizeTest() {
        // Given, When
        Computer computer = new Computer();

        // Then
        assertThat(computer.computersNumber.size()).isEqualTo(3);
    }
}
