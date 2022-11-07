package baseball;

import baseball.model.Computer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {

    private final Computer computer = new Computer();

    @Test
    @DisplayName("컴퓨터 숫자 생성 개수 테스트")
    void randomGenerate() {
        final int COUNT = 3;
        computer.randomGenerate();
        assertThat(computer.getComputerNumberList().size()).isEqualTo(COUNT);
    }
}
