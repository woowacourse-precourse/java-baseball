package baseball;

import baseball.model.Computer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    @DisplayName("게임 초기화시 난수 다르게 생성 됐는지 테스트")
    void resetGame() {
        computer.randomGenerate();
        List<Integer> beforeReset = computer.getComputerNumberList();
        String beforeResetString = String.join("", beforeReset.toString());

        computer.resetGame();
        List<Integer> afterReset = computer.getComputerNumberList();
        String afterResetString =  String.join("", afterReset.toString());

        assertThat(beforeResetString).isNotEqualTo(afterResetString);
    }
}
