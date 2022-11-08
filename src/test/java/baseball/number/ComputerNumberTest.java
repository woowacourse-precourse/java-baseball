package baseball.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerNumberTest {

    @DisplayName("컴퓨터 수에 0이 포함되지 않았는지 확인")
    @Test
    void createComputerNumber_0미포함() {
        ComputerNumber computerNumber = new ComputerNumber();
        assertThat(computerNumber.createComputerNumber()).doesNotContain(0);
    }

    @DisplayName("컴퓨터 수가 3개인지 확인")
    @Test
    void createComputerNumber_3개() {
        ComputerNumber computerNumber = new ComputerNumber();
        assertThat(computerNumber.createComputerNumber().size()).isEqualTo(3);
    }
}