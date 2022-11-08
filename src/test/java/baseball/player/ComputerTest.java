package baseball.player;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.Valid;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputerTest {

    private Computer computer;

    @BeforeEach
    public void setComputer() {
        this.computer = new Computer();
    }

    @Test
    void selectBalls_1_과_9_사이의_랜덤한_공을_3개_선택() {
        computer.selectBalls();

        List<String> selectBalls = computer.getSelectBalls();
        assertThat(selectBalls.size()).isEqualTo(3);
        assertThat(selectBalls.toString()).doesNotMatch(Valid.NOT_INPUT_NUMBER.getPattern());
    }

    @Test
    void clearSelectBalls_선택한_공_지우기() {
        computer.selectBalls();
        computer.clearSelectBalls();

        List<String> selectBalls = computer.getSelectBalls();
        assertThat(selectBalls.size()).isEqualTo(0);
    }
}